package com.mobisi.backend.Api.Repositories.Implementations.Registers;

import com.mobisi.backend.Api.Infrastructure.UserRepository;
import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class RegisterUserRepository {
    private final UserRepository _userRepo;
    public RegisterUserRepository(UserRepository userRepo){
        this._userRepo = userRepo;
    }

    public boolean SignIn(List<UserDAO> listUserDAO, UserDAO objectUser){
        boolean userExists = listUserDAO.removeIf(userDAO -> Objects.equals(userDAO.getEmail(), objectUser.getEmail()));
        if (userExists){
            return false;
        } else {
            _userRepo.save(objectUser);
            return true;
        }
    }

    public boolean LogIn(List<UserDAO> listUserDAO, UserDAO objectUser){
        boolean userExists = listUserDAO.removeIf(userDAO -> !Objects.equals(userDAO.getEmail(), objectUser.getEmail()));
        if (userExists){
            return false;
        } else {
            if (Objects.equals(listUserDAO.get(0).getPassword(), objectUser.getPassword())){
                objectUser.setStatus(true);
                return true;
            } else {
                return false;
            }
        }
    }
}
