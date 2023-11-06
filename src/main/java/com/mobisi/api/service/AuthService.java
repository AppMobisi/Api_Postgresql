package com.mobisi.api.service;

import com.mobisi.api.dto.CreateUserDto;
import com.mobisi.api.dto.SignInDto;
import com.mobisi.api.dto.UserDto;
import com.mobisi.api.exceptions.BaseHttpException;
import com.mobisi.api.exceptions.ExceptionHandler;
import com.mobisi.api.model.DisabilityType;
import com.mobisi.api.model.User;
import com.mobisi.api.repository.UsersRepository;
import com.mobisi.api.utils.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class AuthService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public AuthService(
            UsersRepository usersRepository
    ) {
        this.usersRepository = usersRepository;
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
            System.out.println(data.getDisabilityType());
            User user = modelMapper.map(data, User.class);
            user.setPassword(hashedPassword);
            System.out.println(user.getDisabilityType());
            User savedUser = this.usersRepository.save(user);

            return modelMapper.map(savedUser, UserDto.class);
        } catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }

    public UserDto signIn(SignInDto data) throws BaseHttpException {
        try {
            User user = usersRepository.findByEmail(data.getEmail());
            String disability = user.getDisability().getNome();

            user.setDisabilityType(disability);
            if (user == null) {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), "User with that email was not found");
            }

            if (BCrypt.checkpw(data.getPassword(), user.getPassword())) {
                return modelMapper.map(user, UserDto.class);
            } else {
                throw new BaseHttpException(HttpStatus.UNAUTHORIZED.value(), "Incorrect password");
            }
        } catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }
}