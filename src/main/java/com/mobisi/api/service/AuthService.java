package com.mobisi.api.service;

import com.mobisi.api.dto.CreateUserDto;
import com.mobisi.api.dto.UserDto;
import com.mobisi.api.exceptions.BaseHttpException;
import com.mobisi.api.exceptions.ExceptionHandler;
import com.mobisi.api.model.User;
import com.mobisi.api.repository.UsersRepository;
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

            User user = modelMapper.map(data, User.class);
            user.setPassword(hashedPassword);

            User savedUser = this.usersRepository.save(user);

            return modelMapper.map(savedUser, UserDto.class);
        } catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }

}
