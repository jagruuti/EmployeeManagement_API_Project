package com.jags.myApi.service;

import com.jags.myApi.dto.employeeRequestDTO;
import com.jags.myApi.dto.employeeResponseDTO;
import com.jags.myApi.entity.Employee;
import com.jags.myApi.mapper.employeeMapper;
import com.jags.myApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public employeeResponseDTO create(employeeRequestDTO dto) {
            Employee employee = employeeMapper.toEntity(dto);
            Employee savedEmployee = repo.save(employee);
            return employeeMapper.toResponseDTO(savedEmployee);
    }

    public List<employeeResponseDTO> getAll(){
        return repo.findAll()
                .stream()
                .map(employeeMapper::toResponseDTO)
                .toList();
    }

    public employeeResponseDTO getEmployeeById(Long id){
        Employee employee = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee with id " + id + " not found!"));
        return employeeMapper.toResponseDTO(employee);
    }

//    public List<Employee> getAllEmployees() {
//        return repo.findAll();
//    }
//    public Employee getEmployeeById(int id) {
//        return repo.findById(id).orElse(null);
//    }
//    public Employee addEmployee(Employee employee) {
//        return repo.save(employee);
//    }
//    public Employee updateEmployee(Employee employee) {
//        return repo.save(employee);
//    }
//    public void deleteEmployee(int id) {
//        repo.deleteById(id);
//    }
}
