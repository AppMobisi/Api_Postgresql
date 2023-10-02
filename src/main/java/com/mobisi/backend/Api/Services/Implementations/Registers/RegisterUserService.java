package com.mobisi.backend.Api.Services.Implementations.Registers;

import com.mobisi.backend.Api.Controllers.Requests.loginRequest;
import com.mobisi.backend.Api.Repositories.Implementations.Registers.RegisterUserRepository;
import com.mobisi.backend.Api.Services.Converters.ConvertDTOToDAO;
import com.mobisi.backend.Api.Services.Converters.ConvertListDTOToListDAO;
import com.mobisi.backend.Api.Services.Converters.ConvertloginDTOToUserDTO;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;
import com.mobisi.backend.Api.Services.Implementations.CRUD.ReadUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterUserService {
    private final RegisterUserRepository _registerUserRepository;
    private final ReadUserService _readUserService;
    public RegisterUserService(RegisterUserRepository registerUserRepository, ReadUserService readUserService) {
        _registerUserRepository = registerUserRepository;
        _readUserService = readUserService;
    }
    public boolean SignIn(UserDTO objectUser) {
        List<UserDTO> listUsers = _readUserService.ListAll();
        boolean ok = _registerUserRepository.SignIn(ConvertListDTOToListDAO.Convert(listUsers), ConvertDTOToDAO.Convert(objectUser));
        if (ok){
            return true;
        }else {
            return false;
        }
    }

    public boolean LogIn(loginRequest objectUser) {
        List<UserDTO> listUsers = _readUserService.ListAll();
        boolean ok = _registerUserRepository.LogIn(
                ConvertListDTOToListDAO.Convert(listUsers),
                ConvertDTOToDAO.Convert(
                        ConvertloginDTOToUserDTO.Convert(objectUser)
                ));
        if (ok){
            return true;
        }else {
            return false;
        }
    }
}
