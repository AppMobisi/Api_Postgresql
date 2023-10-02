package com.mobisi.backend.Api.Controllers.Registers;

import com.mobisi.backend.Api.Controllers.ApiResponses.ApiResponse;
import com.mobisi.backend.Api.Controllers.Requests.loginRequest;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;
import com.mobisi.backend.Api.Services.Implementations.Registers.RegisterUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterUserController {

    private final RegisterUserService _registerUserService;

    public RegisterUserController(RegisterUserService registerUserService) {
        _registerUserService = registerUserService;
    }

    @PutMapping("/signIn")
    public ResponseEntity SignIn(@RequestBody UserDTO user){
        boolean ok = _registerUserService.SignIn(user);

        if (ok){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(201, "Usuario cadastrado com sucesso!", null));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ApiResponse(409, "Não foi possivel cadastrar este usuario", null));
        }
    }

    @PutMapping("/login")
    public ResponseEntity LogIn(@RequestBody loginRequest user){
        boolean ok = _registerUserService.LogIn(user);
        if (ok){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(201, "Usuario logado com sucesso!", null));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ApiResponse(409, "Não foi possivel logar com este usuario", null));
        }
    }
}
