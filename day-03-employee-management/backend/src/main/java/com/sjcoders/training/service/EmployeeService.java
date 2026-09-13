package com.sjcoders.training.service;

import com.sjcoders.training.model.Employee;
import com.sjcoders.training.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        // Auto-generate employee code: SJ001, SJ002, ...
        long count = employeeRepository.count() + 1;
        String code = String.format("SJ%03d", count);

        // Ensure uniqueness in case of gaps/deletions
        while (employeeRepository.existsByEmployeeCode(code)) {
            count++;
            code = String.format("SJ%03d", count);
        }

        employee.setEmployeeCode(code);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> searchEmployees(String query) {
        return employeeRepository
                .findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrDepartmentContainingIgnoreCase(
                        query, query, query
                );
    }
}