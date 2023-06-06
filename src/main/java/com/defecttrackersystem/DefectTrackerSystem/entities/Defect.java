package com.defecttrackersystem.DefectTrackerSystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Defect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String stepstorecreate;

    @ManyToOne
    @JoinColumn(name="project_id",nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name="priority_id",nullable = false)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name="seviarity_id",nullable = false)
    private Seviarity seviarity;

    @ManyToOne
    @JoinColumn(name="defectType_id",nullable = false)
    private DefectType defectType;

    @ManyToOne
    @JoinColumn(name="defectStatus_id",nullable = false)
    private DefectStatus defectStatus;

    @ManyToOne
    @JoinColumn(name="assign_id",nullable = false)
    private Employee assignTo;

    @ManyToOne
    @JoinColumn(name="report_id",nullable = false)
    private Employee reportTo;

    @ManyToOne
    @JoinColumn(name="release_id")
    private Release release;





}
