package com.defecttrackersystem.DefectTrackerSystem.service;

import com.defecttrackersystem.DefectTrackerSystem.request.dto.PriorityRequest;
import com.defecttrackersystem.DefectTrackerSystem.response.dto.PriorityResponse;

import java.util.List;

public interface PriorityService {
    public void savePriority(PriorityRequest priorityRequest);

    public boolean isPriorityExistsByName(String name);
    public boolean isPriorityExistsByColor(String color);

    public List<PriorityResponse> getAllPriority();

    public PriorityResponse getPriorityById(Long id);

    public boolean existsByPriorityId(Long id);

    public void deletePriorityById(Long id);

    public boolean isUpdatePriorityNameExists(String name,Long id);

    public boolean isUpdatePriorityColorExists(String color,Long id);

}
