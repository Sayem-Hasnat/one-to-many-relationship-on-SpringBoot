package com.example.assignment.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="Designation")
@Data
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  private long designationId;
    @Column
    private String designationName;

}
