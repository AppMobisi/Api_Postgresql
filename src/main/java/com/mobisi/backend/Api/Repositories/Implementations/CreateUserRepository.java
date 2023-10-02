package com.mobisi.backend.Api.Repositories.Implementations;

import com.mobisi.backend.Api.Infrastructure.UserRepository;
import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import org.springframework.stereotype.Repository;

@Repository
public class CreateUserRepository {
    private final UserRepository _userRepo;

    public CreateUserRepository(UserRepository userRepo){
        this._userRepo = userRepo;
    }

    public void Insert(UserDAO insertUser){
        _userRepo.save(insertUser);
    }
}
