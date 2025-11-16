package com.jags.myApi.repository;

import com.jags.myApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//This acts as the Data Access layer
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
