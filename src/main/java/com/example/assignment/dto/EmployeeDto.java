package com.example.assignment.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private  long id;
    private String name;
    private  int age;
    private String address;
    private double salary;
    private long designationId;
    private String type;
}
