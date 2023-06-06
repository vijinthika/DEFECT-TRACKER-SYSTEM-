package com.defecttrackersystem.DefectTrackerSystem.request.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequest {
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private Long phoneno;
    private String email;

    private Long designationid;
}
