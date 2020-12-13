package com.example.assignment.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private  String address;
    @Column
    private double salary;
    @Column
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="designationId")
    private Designation designation;
}
