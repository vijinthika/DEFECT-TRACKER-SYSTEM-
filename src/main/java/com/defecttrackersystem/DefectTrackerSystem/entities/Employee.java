package com.defecttrackersystem.DefectTrackerSystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private Long phoneno;
    private String email;
    @ManyToOne
    @JoinColumn(name="designation_id",nullable = false)
    private Designation designation;

  }