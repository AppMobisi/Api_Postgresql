package com.mobisi.backend.Api.Services.Validators;

import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;

import java.util.Optional;

public class IsUserList {
    public static boolean Valid(Optional<UserDAO> userDAOOptional){
        return userDAOOptional.isPresent();
    }
}
