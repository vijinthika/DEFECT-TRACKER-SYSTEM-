package com.defecttrackersystem.DefectTrackerSystem.request.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SeviarityRequest {
    private Long id;
    private String name;
    private String color;
}
