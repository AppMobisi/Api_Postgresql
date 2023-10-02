package com.mobisi.backend.Api.Repositories.Implementations;

import com.mobisi.backend.Api.Infrastructure.UserRepository;
import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateUserRepository {
    private final UserRepository _userRepo;

    public UpdateUserRepository(UserRepository userRepo){
        this._userRepo = userRepo;
    }

    public void UpdateById(UserDAO userWillBeUpdated){
        userWillBeUpdated.setName(userWillBeUpdated.getName());
        userWillBeUpdated.setEmail(userWillBeUpdated.getEmail());
        userWillBeUpdated.setPhone(userWillBeUpdated.getPhone());
        userWillBeUpdated.setAge(userWillBeUpdated.getAge());
        userWillBeUpdated.setCep(userWillBeUpdated.getCep());
        userWillBeUpdated.setTypeOfDisability(userWillBeUpdated.getTypeOfDisability());
    }
}
