package com.jags.myApi.controller;

import com.jags.myApi.dto.employeeRequestDTO;
import com.jags.myApi.dto.employeeResponseDTO;
import com.jags.myApi.entity.Employee;
import com.jags.myApi.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
//    private List<Employee> employees=new ArrayList<>(List.of(
//            new employeeRequestDTO("John", "Developer"),
//            new Employee(2, "Jane", "Tester")
//    ));

//    @GetMapping
//    public List<Employee> getEmployees() {
//       // return employees;
//        return service.getAllEmployees();
//    }

        @GetMapping
        public List<employeeResponseDTO> getAll(){
        return service.getAll();
        }

    @Operation(summary = "Get employee by Id.", description = "Fetch employee details using ID." )
    @GetMapping("/employee")
    public employeeResponseDTO getEmployeeById(
            @Parameter(description = "Employee ID", required = true)
            @RequestParam Long id){
                return service.getEmployeeById(id);
    }
//    public Employee getEmployeeById(@PathVariable int id) {
////        return employees.stream()
////                .filter(e->e.getId()== id)
////                .findFirst()
////                .orElse(null);
//        return service.getEmployeeById(id);
//    }
    @PostMapping
    public ResponseEntity<employeeResponseDTO> createEmployee(@Valid @RequestBody employeeRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }
//    @PostMapping
//    public Employee addEmployee(@RequestBody Employee employee) {
////        employees.add(employee);
////        return employee;
//        return service.addEmployee(employee);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteEmployee(@PathVariable int id) {
//        service.deleteEmployee(id);
//    }
}
