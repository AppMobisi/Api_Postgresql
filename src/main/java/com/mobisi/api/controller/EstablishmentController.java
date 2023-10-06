package com.mobisi.api.controller;

import com.mobisi.api.dto.EstablishmentDto;
import com.mobisi.api.exceptions.BaseHttpException;
import com.mobisi.api.responses.ApiResponse;
import com.mobisi.api.responses.DefaultResponse;
import com.mobisi.api.responses.ErrorResponse;
import com.mobisi.api.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {
    private final EstablishmentService establishmentService;

    @Autowired
    public EstablishmentController(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllEstablishments() {
        try {
            List<EstablishmentDto> establishments = this.establishmentService.getAllEstablishments();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new DefaultResponse<>(200, establishments));
        } catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getEstablishmentById(@PathVariable Long id) {
        try {
            EstablishmentDto establishment = this.establishmentService.getEstablishmentById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new DefaultResponse<>(200, establishment));
        } catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEstablishment(@PathVariable Long id) {
        try {
            this.establishmentService.deleteEstablishment(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new DefaultResponse<>(204, null));
        } catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> createEstablishment(@RequestBody EstablishmentDto establishmentDto) {
        try {
            EstablishmentDto createdEstablishment = this.establishmentService.createEstablishment(establishmentDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new DefaultResponse<>(201, createdEstablishment));
        } catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateEstablishment(@PathVariable Long id, @RequestBody EstablishmentDto establishmentDto) {
        try {
            EstablishmentDto updatedEstablishment = this.establishmentService.updateEstablishment(id, establishmentDto);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new DefaultResponse<>(200, updatedEstablishment));
        } catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }

}
