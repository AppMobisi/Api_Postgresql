package com.mobisi.backend.Api.Services.Implementations.CRUD;

import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import com.mobisi.backend.Api.Repositories.Implementations.CRUD.UpdateUserRepository;
import com.mobisi.backend.Api.Services.Converters.ConvertDTOToDAO;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {
    private final UpdateUserRepository _updateUserRepo;
    private final ReadUserService _readUserService;

    public UpdateUserService(UpdateUserRepository updateUserRepository, ReadUserService readUserService){
        _updateUserRepo = updateUserRepository;
        _readUserService = readUserService;
    }

    public void UpdateById(long Id){
        UserDAO userWillBeUpdated = ConvertDTOToDAO.Convert(_readUserService.FindById(Id).get(0));
        _updateUserRepo.UpdateById(userWillBeUpdated);
    }
}
