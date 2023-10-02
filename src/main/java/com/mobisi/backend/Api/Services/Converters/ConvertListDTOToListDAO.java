package com.mobisi.backend.Api.Services.Converters;

import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class ConvertListDTOToListDAO {
    public static List<UserDAO> Convert(List<UserDTO> listUserInFormatDTO) {
        List<UserDAO> listUserInFormatDAO = new ArrayList<UserDAO>();

        for (UserDTO user : listUserInFormatDTO) {
            UserDAO userDAO = new UserDAO();
            userDAO.setId(user.getId());
            userDAO.setName(user.getName());
            userDAO.setEmail(user.getEmail());
            userDAO.setPassword(user.getPassword());
            userDAO.setPhone(user.getPhone());
            userDAO.setAge(user.getAge());
            userDAO.setCep(user.getCep());
            userDAO.setTypeOfDisability(user.getTypeOfDisability());

            listUserInFormatDAO.add(userDAO);
        }

        return listUserInFormatDAO;
    }
}
