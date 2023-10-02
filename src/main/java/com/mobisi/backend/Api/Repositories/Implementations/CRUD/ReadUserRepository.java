package com.mobisi.backend.Api.Repositories.Implementations.CRUD;

import com.mobisi.backend.Api.Infrastructure.UserRepository;
import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReadUserRepository {
    private final UserRepository _userRepo;

    public ReadUserRepository(UserRepository userRepo){
        this._userRepo = userRepo;
    }
    public List<UserDAO> ListAll(){
        return _userRepo.findAll();
    }
    public Optional<UserDAO> FindById(long id){
        return _userRepo.findById(id);
    };
}
