package com.defecttrackersystem.DefectTrackerSystem.service;

import com.defecttrackersystem.DefectTrackerSystem.request.dto.SeviarityRequest;
import com.defecttrackersystem.DefectTrackerSystem.response.dto.SeviarityResponse;

import java.util.List;

public interface SeviarityService {
    public void saveSeviarity(SeviarityRequest seviarityRequest);

    public List<SeviarityResponse> getAllSeviarity();
    public SeviarityResponse getSeviarityByid(Long id);

    public void DeleteSeviarityByid(Long id);



    public boolean existsBySeviarityid(long id);

    public boolean isSeviarityExistsByName(String name);
    public boolean isSeviarityExistsByColor(String color);

    public boolean isUpdateSeviarityNameExists(String name,Long id);

    public boolean isUpdateSeviarityColorExists(String color,Long id);










}
