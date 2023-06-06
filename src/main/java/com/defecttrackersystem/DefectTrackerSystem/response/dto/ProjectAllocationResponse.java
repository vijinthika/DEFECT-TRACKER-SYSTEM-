package com.defecttrackersystem.DefectTrackerSystem.response.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectAllocationResponse {
    private Long id;
    private Long employeeid;
    private Long projectid;
    private Long roleid;

}
