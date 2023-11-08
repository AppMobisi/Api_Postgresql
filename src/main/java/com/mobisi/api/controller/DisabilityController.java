package com.mobisi.api.controller;

import com.mobisi.api.exceptions.BaseHttpException;
import com.mobisi.api.model.DisabilityType;
import com.mobisi.api.responses.ApiResponse;
import com.mobisi.api.responses.DefaultResponse;
import com.mobisi.api.responses.ErrorResponse;
import com.mobisi.api.service.DisabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("disability")
public class DisabilityController {
    private final DisabilityService disabilityService;

    @Autowired
    public DisabilityController(DisabilityService disabilityService) {
        this.disabilityService = disabilityService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> GetById(@PathVariable Long id) {
        try {
            DisabilityType disability = this.disabilityService.GetById(id);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new DefaultResponse<>(200, disability));
        } catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }
}
