    package com.example.hospital.hospitalManagement.service;

    import com.example.hospital.hospitalManagement.entity.Patient;
    import com.example.hospital.hospitalManagement.repository.PatientRepository;
    import jakarta.transaction.Transactional;
    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class PatientService {

        @Autowired
        private PatientRepository patientRepository;

        @Transactional
         public Patient getPatientById(Long id){
            Patient p1 = patientRepository.findById(id).orElseThrow();
            Patient p2 = patientRepository.findById(id).orElseThrow();

            return p1;
        }

        public Patient findByName(String name) {
            Patient p1 =  patientRepository.findByName(name);
            return p1;
        }
    }
