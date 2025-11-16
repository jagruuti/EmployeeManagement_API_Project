package com.jags.myApi.service;

import com.jags.myApi.model.Employee;
import com.jags.myApi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }
    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElse(null);
    }
    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }
    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
}
