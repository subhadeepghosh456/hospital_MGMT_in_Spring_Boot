package com.example.hospital.hospitalManagement.repository;

import com.example.hospital.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}