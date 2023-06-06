package com.defecttrackersystem.DefectTrackerSystem.controler;

import com.defecttrackersystem.DefectTrackerSystem.request.dto.SeviarityRequest;
import com.defecttrackersystem.DefectTrackerSystem.response.dto.SeviarityResponse;
import com.defecttrackersystem.DefectTrackerSystem.service.SeviarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SeviarityController {
    @Autowired
   private SeviarityService seviarityService;

    @PostMapping("/createSeviarity")
    public ResponseEntity<String> saveSeviarity(@RequestBody SeviarityRequest seviarityRequest){
        if(seviarityService.isSeviarityExistsByName(seviarityRequest.getName())) {
            return new ResponseEntity<String>("This name already exists", HttpStatus.BAD_REQUEST);
        }
        if(seviarityService.isSeviarityExistsByColor(seviarityRequest.getColor())){
            return new ResponseEntity<String>("This color already exists",HttpStatus.BAD_REQUEST);
        }
        seviarityService.saveSeviarity(seviarityRequest);
        return new ResponseEntity<String>("saved Successfully",HttpStatus.OK);
    }

    @GetMapping("/getAllSeviarity")
    public ResponseEntity<List<SeviarityResponse>> getAllSeviarity() {
        List<SeviarityResponse> seviarityResponseList=seviarityService.getAllSeviarity();
        return new ResponseEntity<List<SeviarityResponse>>(seviarityResponseList,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSeviarityByid(@PathVariable Long id){
        if(!seviarityService.existsBySeviarityid(id)) {
            return ResponseEntity.ok("this id is null");
        }

        SeviarityResponse seviarityResponse=seviarityService.getSeviarityByid(id);
        return ResponseEntity.ok(seviarityResponse);
    }
    @PutMapping("/updateSeviarity")
    public ResponseEntity<String> updateSeviarity(@RequestBody SeviarityRequest seviarityRequest){
        if(!seviarityService.existsBySeviarityid(seviarityRequest.getId())){
            return new ResponseEntity<String>("This id is not valid",HttpStatus.BAD_REQUEST);
        }
        if(seviarityService.isUpdateSeviarityNameExists(seviarityRequest.getName(), seviarityRequest.getId())){
            return new ResponseEntity<String>("This name already exists",HttpStatus.OK);
        }
        if(seviarityService.isUpdateSeviarityColorExists(seviarityRequest.getColor(), seviarityRequest.getId())){
            return new ResponseEntity<String>("This color already exists",HttpStatus.OK);
        }
        seviarityService.saveSeviarity(seviarityRequest);
        return new ResponseEntity<String>("updated Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteSeviarityByid(@PathVariable Long id){
        if(!seviarityService.existsBySeviarityid(id)) {
           return new ResponseEntity<String>("This id is not valid",HttpStatus.OK);
        }

        seviarityService.DeleteSeviarityByid(id);
        return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
    }







}
