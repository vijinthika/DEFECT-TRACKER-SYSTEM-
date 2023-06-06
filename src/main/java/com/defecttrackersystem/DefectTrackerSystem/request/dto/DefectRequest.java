package com.defecttrackersystem.DefectTrackerSystem.request.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DefectRequest {
    private Long id;
    private String name;
    private String description;
    private String stepstorecreate;
    private Long priorityid;
    private Long seviarityid;
    private Long projectid;
    private Long defectTypeid;
    private Long defectStatusid;
    private Long assignid;
    private Long reportid;
    private Long releaseid;


}
