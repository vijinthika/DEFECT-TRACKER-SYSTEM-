package com.defecttrackersystem.DefectTrackerSystem.response.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class ProjectResponse {
    private Long id;
    private String name;
    private String contactname;
    private Date startdate;
    private Date Enddate;
    private Long contactno;
    private Long projectStatusid;
}
