package com.mobisi.api.service;

import com.mobisi.api.dto.CreateUserDto;
import com.mobisi.api.dto.SignInDto;
import com.mobisi.api.dto.UserDto;
import com.mobisi.api.exceptions.BaseHttpException;
import com.mobisi.api.exceptions.ExceptionHandler;
import com.mobisi.api.model.DisabilityType;
import com.mobisi.api.model.User;
import com.mobisi.api.repository.DisabilityTypeRepository;
import com.mobisi.api.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {
    private final UsersRepository usersRepository;
    private final DisabilityTypeRepository disabilityTypeRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public AuthService(
            UsersRepository usersRepository,
            DisabilityTypeRepository disabilityTypeRepository
    ) {
        this.usersRepository = usersRepository;
        this.disabilityTypeRepository = disabilityTypeRepository;
    }

    public UserDto signUp(CreateUserDto data) throws BaseHttpException {
        try {
            if (usersRepository.existsByEmail(data.getEmail())) {
                throw new BaseHttpException(
                        HttpStatus.CONFLICT.value(),
                        "User with this email already exists"
                );
            }

            String hashedPassword = BCrypt.hashpw(data.getPassword(), BCrypt.gensalt());
            User user = modelMapper.map(data, User.class);
            Optional<DisabilityType> disabilityType = disabilityTypeRepository.findById(Long.valueOf(data.getDisabilityType()));
            user.setDisability(disabilityType.get());
            user.setPassword(hashedPassword);
            user.setCreateAt(new Date());
            User savedUser = this.usersRepository.save(user);

            return modelMapper.map(savedUser, UserDto.class);
        } catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }

    public UserDto signIn(SignInDto data) throws BaseHttpException {
        try {
            User user = usersRepository.findByEmail(data.getEmail());

            if (user == null) {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), "User with that email was not found");
            }
            String disability = user.getDisability().getNome();
            user.setDisabilityType(disability);

            if (BCrypt.checkpw(data.getPassword(), user.getPassword())) {
                user.setDisabilityType(String.valueOf(user.getDisability().getId()));
                return modelMapper.map(user, UserDto.class);
            } else {
                throw new BaseHttpException(HttpStatus.UNAUTHORIZED.value(), "Incorrect password");
            }
        } catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }
}