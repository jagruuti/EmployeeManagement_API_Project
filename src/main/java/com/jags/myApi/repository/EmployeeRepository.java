package com.jags.myApi.repository;

import com.jags.myApi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This acts as the Data Access layer
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
