package com.jags.myApi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class employeeRequestDTO {
    @NotBlank(message="First Name cannot be blank")
    private String firstName;
    @NotBlank(message="Last Name cannot be blank")
    private String lastName;
    @Email(message="Invalid email format")
    @NotBlank(message="Email cannot be blank")
    private String email;
    private String department;
    @Positive(message="Salary must be positive")
    private double salary;
}
