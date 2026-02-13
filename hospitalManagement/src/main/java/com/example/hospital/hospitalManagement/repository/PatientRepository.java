package com.example.hospital.hospitalManagement.repository;

import com.example.hospital.hospitalManagement.entity.Patient;
import com.example.hospital.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate date, String email);

//    @Query("SELECT p FROM Patient p where p.bloodGroup=?1")
//    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p from Patient p where p.birthDate > :date")
    List<Patient> findByBornAfterDate(@Param("date") LocalDate date);

    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
    List<Object[]>  countEachBloodGroupType();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id= :id")
    int updateNameWithId(@Param("name") String name,@Param("id") Long id);




}
