package com.defecttrackersystem.DefectTrackerSystem.service.impl;

import com.defecttrackersystem.DefectTrackerSystem.entities.Seviarity;
import com.defecttrackersystem.DefectTrackerSystem.repositories.SeviarityRepository;
import com.defecttrackersystem.DefectTrackerSystem.request.dto.SeviarityRequest;
import com.defecttrackersystem.DefectTrackerSystem.response.dto.SeviarityResponse;
import com.defecttrackersystem.DefectTrackerSystem.service.SeviarityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeviarityServiceImpl implements SeviarityService {
    @Autowired
    private SeviarityRepository seviarityRepository;

    @Override
    public void saveSeviarity(SeviarityRequest seviarityRequest) {
        Seviarity seviarity= new Seviarity();
        BeanUtils.copyProperties(seviarityRequest,seviarity);
        seviarityRepository.save(seviarity);
    }

    @Override
    public List<SeviarityResponse> getAllSeviarity() {
        List<SeviarityResponse> seviarityResponseList=new ArrayList<>();
        List<Seviarity> seviarityList=seviarityRepository.findAll();
        for(Seviarity seviarity:seviarityList){
            SeviarityResponse seviarityResponse=new SeviarityResponse();
            BeanUtils.copyProperties(seviarity,seviarityResponse);
            seviarityResponseList.add(seviarityResponse);
        }
        return seviarityResponseList;
    }

    @Override
    public SeviarityResponse getSeviarityByid(Long id) {
        SeviarityResponse seviarityResponse=new SeviarityResponse();
        Seviarity seviarity=seviarityRepository.findById(id).get();
        BeanUtils.copyProperties(seviarity,seviarityResponse);
        return seviarityResponse;
    }

    @Override
    public void DeleteSeviarityByid(Long id) {
        seviarityRepository.deleteById(id);
    }

    @Override
    public boolean existsBySeviarityid(long id) {
        return seviarityRepository.existsById(id);
    }

    @Override
    public boolean isSeviarityExistsByName(String name) {
        return seviarityRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public boolean isSeviarityExistsByColor(String color) {
        return seviarityRepository.existsByColorIgnoreCase(color);
    }

    @Override
    public boolean isUpdateSeviarityNameExists(String name, Long id) {
        return seviarityRepository.existsByNameIgnoreCaseAndIdNot(name,id);
    }

    @Override
    public boolean isUpdateSeviarityColorExists(String color, Long id) {
        return seviarityRepository.existsByColorIgnoreCaseAndIdNot(color,id);
    }


}
