package com.defecttrackersystem.DefectTrackerSystem.controler;

import com.defecttrackersystem.DefectTrackerSystem.common.response.BaseResponse;
import com.defecttrackersystem.DefectTrackerSystem.common.response.ContentResponse;
import com.defecttrackersystem.DefectTrackerSystem.request.dto.PriorityRequest;
import com.defecttrackersystem.DefectTrackerSystem.response.dto.PriorityResponse;
import com.defecttrackersystem.DefectTrackerSystem.rest.enums.RequestStatus;
import com.defecttrackersystem.DefectTrackerSystem.service.PriorityService;
import com.defecttrackersystem.DefectTrackerSystem.utils.Constants;
import com.defecttrackersystem.DefectTrackerSystem.utils.EndpointURI;
import com.defecttrackersystem.DefectTrackerSystem.utils.ValidationFailureResponseCode;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class priorityController {
    @Autowired
    private PriorityService priorityService;
    @Autowired
    private ValidationFailureResponseCode validationFailureResponseCode;

    @PostMapping(value=EndpointURI.PRIORITY)
    public ResponseEntity<Object> savePriority(@RequestBody PriorityRequest priorityRequest)
    {
        if(priorityService.isPriorityExistsByName(priorityRequest.getName()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationFailureResponseCode.getPriorityAlreadyExists(),
                    validationFailureResponseCode.getValidationPriorityAlreadyExists()));
        }
        if(priorityService.isPriorityExistsByColor(priorityRequest.getColor()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationFailureResponseCode.getPriorityAlreadyExists(),
                    validationFailureResponseCode.getValidationPriorityAlreadyExists()));
        }
        priorityService.savePriority(priorityRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationFailureResponseCode.getCommonSuccessCode(),
                validationFailureResponseCode.getSavePrioritySuccessMessage()));
    }

    @PutMapping(value = EndpointURI.PRIORITY)
    public ResponseEntity<Object> updatePriority(@RequestBody PriorityRequest priorityRequest) {
        if (!priorityService.existsByPriorityId(priorityRequest.getId()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationFailureResponseCode.getPriorityNotExistsCode(),
                    validationFailureResponseCode.getPriorityNotExistsMessage()));
        }
        if(priorityService.isUpdatePriorityColorExists(priorityRequest.getColor(),priorityRequest.getId()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationFailureResponseCode.getPriorityAlreadyExists(),
                    validationFailureResponseCode.getValidationPriorityAlreadyExists()));
        }
        if(priorityService.isUpdatePriorityNameExists(priorityRequest.getName(),priorityRequest.getId()))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationFailureResponseCode.getPriorityAlreadyExists(),
                    validationFailureResponseCode.getValidationPriorityAlreadyExists()));
        }
        priorityService.savePriority(priorityRequest);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationFailureResponseCode.getCommonSuccessCode(),
                validationFailureResponseCode.getSavePrioritySuccessMessage()));
    }

    @GetMapping(value=EndpointURI.PRIORITY)
    public ResponseEntity<Object> getAllPriority()
    {
        return ResponseEntity.ok(new ContentResponse<>(Constants.PRIORITIES,priorityService.getAllPriority(),
                RequestStatus.SUCCESS.getStatus(),
                validationFailureResponseCode.getCommonSuccessCode(),
                validationFailureResponseCode.getGetAllPrioritySuccessMessage()));
    }

    @GetMapping(value = EndpointURI.PRIORITY_BY_ID)
    public ResponseEntity<Object> getPriorityById(@PathVariable Long id)
    {
        if(!priorityService.existsByPriorityId(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationFailureResponseCode.getPriorityNotExistsCode(),
                    validationFailureResponseCode.getPriorityNotExistsMessage()));
        }
        return ResponseEntity.ok(new ContentResponse<>(Constants.PRIORITY,priorityService.getPriorityById(id),
                RequestStatus.SUCCESS.getStatus(),validationFailureResponseCode.getCommonSuccessCode(),
                validationFailureResponseCode.getGetPriorityByIdSuccessMessage()));
    }

    @DeleteMapping(value = EndpointURI.PRIORITY_BY_ID)
    public ResponseEntity<Object> deletePriorityById(@PathVariable Long id)
    {
        if(!priorityService.existsByPriorityId(id))
        {
            return ResponseEntity.ok(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                    validationFailureResponseCode.getPriorityNotExistsCode(),
                    validationFailureResponseCode.getPriorityNotExistsMessage()));
        }
        priorityService.deletePriorityById(id);
        return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
                validationFailureResponseCode.getCommonSuccessCode(),
                validationFailureResponseCode.getDeletePrioritySuccessMessage()));
    }

}
