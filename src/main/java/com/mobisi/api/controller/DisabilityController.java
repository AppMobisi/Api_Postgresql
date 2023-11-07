package com.mobisi.api.controller;

import com.mobisi.api.exceptions.BaseHttpException;
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
    public ResponseEntity<ApiResponse> getDisabilityById(@PathVariable Long id) {
        try {
            this.disabilityService.getDisabilityById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new DefaultResponse<>(204, null));
        } catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }
}
