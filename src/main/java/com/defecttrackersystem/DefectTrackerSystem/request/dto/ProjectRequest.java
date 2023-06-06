package com.defecttrackersystem.DefectTrackerSystem.request.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProjectRequest {
    private Long id;
    private String name;
    private String contactname;
    private Date startdate;
    private Date Enddate;
    private Long contactno;
    private Long projectStatusid;
}
