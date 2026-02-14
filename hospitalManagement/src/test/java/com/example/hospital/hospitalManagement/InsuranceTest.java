package com.example.hospital.hospitalManagement;

import com.example.hospital.hospitalManagement.entity.Appointment;
import com.example.hospital.hospitalManagement.entity.Insurance;
import com.example.hospital.hospitalManagement.entity.Patient;
import com.example.hospital.hospitalManagement.service.AppointmentService;
import com.example.hospital.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234").provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println("------------->" + patient);

        Patient newPatient=insuranceService.disassociateInsuranceFromPatient(patient.getId());

        System.out.println("newPatient "+newPatient);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder().
                appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 20))
                .reason("cancer")
                .build();

        Appointment newAppointment =  appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println("newAppointment: " + newAppointment);

        Appointment updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(appointment.getId(),3L);
        System.out.println("updatedAppointment: "+updatedAppointment);


    }
}
