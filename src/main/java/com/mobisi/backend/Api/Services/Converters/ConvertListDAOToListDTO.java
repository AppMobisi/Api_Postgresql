package com.mobisi.backend.Api.Services.Converters;

import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class ConvertListDAOToListDTO {
    public static List<UserDTO> Convert (List<UserDAO> listUserInFormatDAO){
        List<UserDTO> listUserInFormatDTO = new ArrayList<UserDTO>();

        for (UserDAO user : listUserInFormatDAO) {
            listUserInFormatDTO.add(new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getPhone(),
                    user.getAge(),
                    user.getCep(),
                    user.getTypeOfDisability()
            ));
        }

        return listUserInFormatDTO;
    }
}
