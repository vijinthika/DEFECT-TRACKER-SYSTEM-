package com.defecttrackersystem.DefectTrackerSystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactname;
    private Date startdate;
    private Date Enddate;
    private Long contactno;

    @ManyToOne
    @JoinColumn(name ="projectStatus_id",nullable = false)
    private ProjectStatus projectStatus;


}
