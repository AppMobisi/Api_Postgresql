package com.mobisi.backend.Api.Services.Implementations.CRUD;

import com.mobisi.backend.Api.Repositories.Implementations.CRUD.ReadUserRepository;
import com.mobisi.backend.Api.Services.Converters.ConvertListDAOToListDTO;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;
import com.mobisi.backend.Api.Services.Validators.IsUserList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ReadUserService {
    private final ReadUserRepository _readUserRepository;
    public ReadUserService(ReadUserRepository readUserRepository){
        _readUserRepository = readUserRepository;
    }

    public List<UserDTO> ListAll(){
        return ConvertListDAOToListDTO.Convert(_readUserRepository.ListAll());
    }

    public List<UserDTO> FindById(long id){
        List<UserDTO> voidList = new ArrayList<UserDTO>(){};
        if (IsUserList.Valid(_readUserRepository.FindById(id))){
            return ConvertListDAOToListDTO.Convert(_readUserRepository.ListAll());
        } else {
            return voidList;
        }
    }
}
