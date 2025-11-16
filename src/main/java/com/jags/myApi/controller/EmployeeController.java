package com.jags.myApi.controller;

import com.jags.myApi.model.Employee;
import com.jags.myApi.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    private List<Employee> employees=new ArrayList<>(List.of(
            new Employee(1, "John", "Developer"),
            new Employee(2, "Jane", "Tester")
    ));

    @GetMapping
    public List<Employee> getEmployees() {
       // return employees;
        return service.getAllEmployees();
    }

    @Operation(summary = "Get employee by Id.", description = "Fetch employee details using ID." )
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
//        return employees.stream()
//                .filter(e->e.getId()== id)
//                .findFirst()
//                .orElse(null);
        return service.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
//        employees.add(employee);
//        return employee;
        return service.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
    }
}
