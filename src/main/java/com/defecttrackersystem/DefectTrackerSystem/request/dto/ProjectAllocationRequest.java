package com.defecttrackersystem.DefectTrackerSystem.request.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectAllocationRequest {
    private Long id;
    private Long employeeid;
    private Long projectid;
    private Long roleid;

}
