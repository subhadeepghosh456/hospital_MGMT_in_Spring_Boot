package com.example.hospital.hospitalManagement.entity;

import com.example.hospital.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(uniqueConstraints = {

        @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthDate"})},
        indexes = {@Index(name = "idx_patient_birth_date", columnList = "birthDate")})
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    private LocalDate birthDate;

    @Column(unique = true)
    private String email;
    private String gender;


    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();
}
