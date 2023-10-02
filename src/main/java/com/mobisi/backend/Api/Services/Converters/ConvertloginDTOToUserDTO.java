package com.mobisi.backend.Api.Services.Converters;

import com.mobisi.backend.Api.Controllers.Requests.loginRequest;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;

public class ConvertloginDTOToUserDTO {
    public static UserDTO Convert(loginRequest loginUser){
        return new UserDTO(
                0,
                " ",
                loginUser.getEmail(),
                loginUser.getSenha(),
                " ",
                0,
                " ",
                0
        );
    }
}
