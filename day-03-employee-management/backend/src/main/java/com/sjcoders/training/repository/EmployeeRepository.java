package com.sjcoders.training.repository;

import com.sjcoders.training.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrDepartmentContainingIgnoreCase(
            String fullName,
            String email,
            String department
    );

    boolean existsByEmployeeCode(String employeeCode);
}