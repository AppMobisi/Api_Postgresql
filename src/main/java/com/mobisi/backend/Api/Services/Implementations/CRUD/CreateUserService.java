package com.mobisi.backend.Api.Services.Implementations.CRUD;

import com.mobisi.backend.Api.Repositories.Implementations.CRUD.CreateUserRepository;
import com.mobisi.backend.Api.Services.Converters.ConvertDTOToDAO;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    private final CreateUserRepository _createUserRepository;

    public CreateUserService(CreateUserRepository createUserRepository) {
        _createUserRepository = createUserRepository;
    }

    public boolean Insert(UserDTO insertUser){
        _createUserRepository.Insert(ConvertDTOToDAO.Convert(insertUser));
        return true;
    }
}
