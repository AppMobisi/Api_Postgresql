package com.mobisi.backend.Api.Controllers.CRUD;

import com.mobisi.backend.Api.Controllers.ApiResponses.ApiResponse;
import com.mobisi.backend.Api.Services.Implementations.CRUD.DeleteUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DeleteUserController {
    private final DeleteUserService _deleteUserService;

    public DeleteUserController(DeleteUserService deleteUserService) {
        _deleteUserService = deleteUserService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> DeleteById(@PathVariable Long id){
        _deleteUserService.DeleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ApiResponse<>(204, "Usuário deletado com sucesso", null));
    }
}
