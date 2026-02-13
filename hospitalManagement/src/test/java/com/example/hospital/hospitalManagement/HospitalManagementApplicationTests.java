package com.example.hospital.hospitalManagement;

import com.example.hospital.hospitalManagement.repository.PatientRepository;
import com.example.hospital.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalManagementApplicationTests {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientService patientService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testTransactionMethod(){

	}

}
