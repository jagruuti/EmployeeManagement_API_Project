package com.jags.myApi.model;

import jakarta.persistence.*;
// Not using model anymore
//@Entity
//@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
  //  private String lastName;
    //private String email;
    private String role;
    public Employee(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    //Default constructor . Spring needs this for JSON serialization
    public Employee() {

    }
    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
