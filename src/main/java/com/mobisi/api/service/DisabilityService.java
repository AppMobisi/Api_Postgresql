package com.mobisi.api.service;

import com.mobisi.api.exceptions.BaseHttpException;
import com.mobisi.api.exceptions.ExceptionHandler;
import com.mobisi.api.model.DisabilityType;
import com.mobisi.api.model.Establishment;
import com.mobisi.api.repository.DisabilityTypeRepository;
import com.mobisi.api.repository.EstablishmentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisabilityService {
    private final DisabilityTypeRepository disabilityTypeRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public DisabilityService(DisabilityTypeRepository disabilityTypeRepository) {
        this.disabilityTypeRepository = disabilityTypeRepository;
    }

    public DisabilityType GetById(Long id) throws BaseHttpException {
        try {
            Optional<DisabilityType> data = this.disabilityTypeRepository.findById(id);

            if (data.isEmpty()) {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("Disability with id %s was not found", id));
            }

            DisabilityType disability = data.get();

            return disability;
        } catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }
}