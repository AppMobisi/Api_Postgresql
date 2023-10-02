package com.mobisi.backend.Api.Repositories.Implementations;

import com.mobisi.backend.Api.Infrastructure.UserRepository;
import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteUserRepository {
    private final UserRepository _userRepo;

    public DeleteUserRepository(UserRepository userRepo){
        this._userRepo = userRepo;
    }

    public void DeleteById(UserDAO userWillBeDeleted){
        userWillBeDeleted.setStatus(false);
    }
}

