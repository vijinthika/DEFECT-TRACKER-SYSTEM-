package com.defecttrackersystem.DefectTrackerSystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class ProjectAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="project_id",nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name="employee_id",nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="Role_id",nullable = false)
    private Role role;



}
