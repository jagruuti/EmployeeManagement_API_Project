package com.jags.myApi.mapper;

import com.jags.myApi.dto.employeeRequestDTO;
import com.jags.myApi.dto.employeeResponseDTO;
import com.jags.myApi.entity.Employee;

public class employeeMapper {
    //Convert request DTO -> Entity (For Create and update)
    public static Employee toEntity(employeeRequestDTO dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        return employee;
    }
    //Convert Entity -> Response DTO (For sending clean data to client)
    public static employeeResponseDTO toResponseDTO(Employee employee) {
        employeeResponseDTO responseDTO = new employeeResponseDTO();
        responseDTO.setId(employee.getId());
        responseDTO.setFirstName(employee.getFirstName());
        responseDTO.setLastName(employee.getLastName());
        responseDTO.setEmail(employee.getEmail());
        responseDTO.setDepartment(employee.getDepartment());
        responseDTO.setSalary(employee.getSalary());
        return responseDTO;
    }

    //Update existing entity from request DTO(used in PUT)
    public void updateEntityFromDTO(employeeRequestDTO dto, Employee employee) {
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
    }
}
