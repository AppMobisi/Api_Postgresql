package com.mobisi.backend.Api.Services.Converters;

import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class ConvertDTOToDAO    {

    public static UserDAO Convert(UserDTO user){
       return  new UserDAO(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getAge(),
                user.getCep(),
                " ",
                " ",
                " ",
                " ",
                user.getTypeOfDisability()
        );
    }
}
