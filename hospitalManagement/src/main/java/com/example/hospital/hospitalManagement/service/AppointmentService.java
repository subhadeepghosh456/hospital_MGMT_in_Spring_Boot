package com.example.hospital.hospitalManagement.service;

import com.example.hospital.hospitalManagement.entity.Appointment;
import com.example.hospital.hospitalManagement.entity.Doctor;
import com.example.hospital.hospitalManagement.entity.Patient;
import com.example.hospital.hospitalManagement.repository.AppointmentRepository;
import com.example.hospital.hospitalManagement.repository.DoctorRepository;
import com.example.hospital.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null){
            throw new IllegalArgumentException("Appointment should not have a ID");
        }

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);

       return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId,Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
         appointment.setDoctor(doctor);

         doctor.getAppointments().add(appointment);

         return appointment;

    }
}
