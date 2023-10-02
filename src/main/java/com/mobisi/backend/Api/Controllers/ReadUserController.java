package com.mobisi.backend.Api.Controllers;

import com.mobisi.backend.Api.Controllers.ApiResponses.ApiResponse;
import com.mobisi.backend.Api.Services.DTOs.UserDTO;
import com.mobisi.backend.Api.Services.Implementations.ReadUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ReadUserController {
    private final ReadUserService _readUserService;
    public ReadUserController(ReadUserService readUserService){
        _readUserService = readUserService;
    }
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<UserDTO>>> ListAll(){
        List<UserDTO> users = _readUserService.ListAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(200, "Usuários retornados com sucesso", users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<UserDTO>>> ListAll(@PathVariable long Id){
        List<UserDTO> users = _readUserService.FindById(Id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(200, "Usuário retornado com sucesso", users));
    }
}
