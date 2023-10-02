package com.mobisi.backend.Api.Infrastructure;

import com.mobisi.backend.Api.Repositories.DAOs.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDAO, Long> {

}