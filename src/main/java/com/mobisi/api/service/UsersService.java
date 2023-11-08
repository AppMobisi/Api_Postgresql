package com.mobisi.api.service;

import com.mobisi.api.dto.AlterUserDto;
import com.mobisi.api.dto.UserDto;
import com.mobisi.api.exceptions.BaseHttpException;
import com.mobisi.api.exceptions.ExceptionHandler;
import com.mobisi.api.model.User;
import com.mobisi.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<UserDto> GetAllUsers() throws BaseHttpException {
        try {
            System.out.println("0");
            List<User> users = this.usersRepository.findAll();
            System.out.println("1");

            return users
                    .stream()
                    .map(user -> modelMapper.map(user, UserDto.class))
                    .collect(Collectors.toList());
        }
        catch(Exception exc) {
            System.out.println(exc);
            throw ExceptionHandler.handleHttpException(exc);
        }
    }


    public UserDto GetById(Long id) throws BaseHttpException {
        try {
            Optional<User> data = this.usersRepository.findById(id);

            if (data.isEmpty()) {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("User with id %s was not found", id));
            }

            User user = data.get();

            return modelMapper.map(user, UserDto.class);
        }
        catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }

    public List<UserDto> GetByEmail(String email) throws BaseHttpException {
        try {
            User user = this.usersRepository.findByEmail(email);

            if (user != null) {
                return Collections.singletonList(modelMapper.map(user, UserDto.class));
            } else {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("User with email %s was not found", email));
            }
        }
        catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }

    public void DeleteById(Long id) throws BaseHttpException {

        try {
            Optional<User> data = this.usersRepository.findById(id);

            if (data.isEmpty()) {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("User with id %s was not found", id));
            }

            User user = data.get();
            user.setStatus(0);
            usersRepository.save(user);

        } catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }

    public void UpdateById(Long id, AlterUserDto alterUser) throws BaseHttpException {
        try {
            Optional<User> data = this.usersRepository.findById(id);

            if (data.isEmpty()) {
                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("User with id %s was not found", id));
            }


            User user = data.get();
            user.setName(alterUser.getName());
            user.setPhone(alterUser.getPhone());
            user.setCep(alterUser.getCep());
            user.setNeighborhood(alterUser.getNeighborhood());
            user.setState(alterUser.getState());
            user.setCity(alterUser.getCity());
            user.setUpdateAt(new Date());

            usersRepository.save(user);

        } catch (Exception exc) {
            throw ExceptionHandler.handleHttpException(exc);
        }
    }
}