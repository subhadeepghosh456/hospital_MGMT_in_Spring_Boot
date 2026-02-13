package com.example.hospital.hospitalManagement;

import com.example.hospital.hospitalManagement.entity.Patient;
import com.example.hospital.hospitalManagement.entity.type.BloodGroupType;
import com.example.hospital.hospitalManagement.repository.PatientRepository;
import com.example.hospital.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }


    @Test
    public void testTransactionMethods() {
//        Patient patient = patientService.getPatientById(1L);

//        Patient patient = patientRepository.findByName("Dishant Verma");

//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1993, 3, 14));
//
//
//        for (Patient patient : patientList) {
//            System.out.println(patient);
//        }
//
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//
//        for(Object[] objects: bloodGroupList){
//            System.out.println(objects[0]+ " "+ objects[1]);
//        }

        List<Patient> allList = patientRepository.findAll();

        for(Patient patient:allList){
            System.out.println(patient);
        }

        int rowsCount = patientRepository.updateNameWithId("Arav Sharma",1L);

        System.out.println(rowsCount);

    }
}
