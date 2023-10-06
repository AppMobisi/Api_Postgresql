package com.mobisi.api.service;

import com.mobisi.api.dto.EstablishmentDto;
import com.mobisi.api.dto.UserDto;
import com.mobisi.api.exceptions.BaseHttpException;
import com.mobisi.api.exceptions.HttpExceptionHandler;
import com.mobisi.api.model.Establishment;
import com.mobisi.api.model.User;
import com.mobisi.api.repository.EstablishmentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstablishmentService {
    private final EstablishmentsRepository establishmentsRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public EstablishmentService(EstablishmentsRepository establishmentsRepository) {
        this.establishmentsRepository = establishmentsRepository;
    }

    public List<EstablishmentDto> getAllEstablishments() throws BaseHttpException{
        try{
            List<Establishment> establishments = this.establishmentsRepository.findAll();
            return establishments
                    .stream()
                    .map(establishment -> modelMapper.map(establishment, EstablishmentDto.class))
                    .collect(Collectors.toList());
        }
        catch (Exception exc){
            throw HttpExceptionHandler.handleException(exc);
        }
    }

    public EstablishmentDto getEstablishmentById(Long id) throws BaseHttpException {
        try {
            Optional<Establishment> data = this.establishmentsRepository.findById(id);

            if (data.isEmpty()) {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("Establishment with id %s was not found", id));
            }

            Establishment establishment = data.get();

            return modelMapper.map(establishment, EstablishmentDto.class);
        }
        catch (Exception exc) {
            throw HttpExceptionHandler.handleException(exc);
        }
    }

    public void deleteEstablishment(Long id) throws BaseHttpException {
        try {
            Optional<Establishment> data = this.establishmentsRepository.findById(id);

            if (data.isEmpty()) {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("User with id %s was not found", id));
            }

            Establishment establishment = data.get();
            this.establishmentsRepository.delete(establishment);
        } catch (Exception exc) {
            throw HttpExceptionHandler.handleException(exc);
        }
    }

    public EstablishmentDto createEstablishment(EstablishmentDto establishmentDto) throws BaseHttpException {
        try {
            Establishment establishment = modelMapper.map(establishmentDto, Establishment.class);

            Establishment savedEstablishment = establishmentsRepository.save(establishment);

            return modelMapper.map(savedEstablishment, EstablishmentDto.class);
        } catch (Exception exc) {
            throw HttpExceptionHandler.handleException(exc);
        }
    }

    public EstablishmentDto updateEstablishment(Long id, EstablishmentDto establishmentDto) throws BaseHttpException {
        try {
            Optional<Establishment> data = establishmentsRepository.findById(id);

            if (data.isEmpty()) {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("Establishment with id %s was not found", id));
            }

            Establishment existingEstablishment = data.get();

            Establishment updatedEstablishment = establishmentsRepository.save(existingEstablishment);

            return modelMapper.map(updatedEstablishment, EstablishmentDto.class);
        } catch (Exception exc) {
            throw HttpExceptionHandler.handleException(exc);
        }
    }


}
