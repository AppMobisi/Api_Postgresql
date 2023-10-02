package com.mobisi.backend.Api.Services.Implementations;

import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import com.mobisi.backend.Api.Repositories.Implementations.DeleteUserRepository;
import com.mobisi.backend.Api.Services.Converters.ConvertDTOToDAO;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {
    private final DeleteUserRepository _deleteUserRepository;
    private final ReadUserService _readUserService;

    public DeleteUserService(DeleteUserRepository deleteUserRepository, ReadUserService readUserService) {
        _deleteUserRepository = deleteUserRepository;
        _readUserService = readUserService;
    }

    public void DeleteById(long Id){
        UserDAO userWillBeDeleted = ConvertDTOToDAO.Convert(_readUserService.FindById(Id).get(0));
        _deleteUserRepository.DeleteById(userWillBeDeleted);
    }
}
