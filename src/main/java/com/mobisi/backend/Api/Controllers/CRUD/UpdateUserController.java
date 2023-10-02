package com.mobisi.backend.Api.Controllers.CRUD;

import com.mobisi.backend.Api.Controllers.ApiResponses.ApiResponse;
import com.mobisi.backend.Api.Services.Implementations.CRUD.UpdateUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UpdateUserController {
    private final UpdateUserService _updateUserService;

    public UpdateUserController(UpdateUserService updateUserService) {
        _updateUserService = updateUserService;
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Object>> UpdateById(@PathVariable long Id){
        _updateUserService.UpdateById(Id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ApiResponse<>(204, "Usuário atualizado com sucesso", null));
    }
}
