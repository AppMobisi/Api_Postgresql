package com.mobisi.backend.Api.Controllers;

import com.mobisi.backend.Api.Controllers.ApiResponses.ApiResponse;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;
import com.mobisi.backend.Api.Services.Implementations.CreateUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class CreateUserController {
    private final CreateUserService _createUserService;

    public CreateUserController(CreateUserService createUserService) {
        _createUserService = createUserService;
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Object>> Insert(@RequestBody UserDTO user){
       _createUserService.Insert(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(201, "Usuário adicionado com sucesso", null));
    }
}
