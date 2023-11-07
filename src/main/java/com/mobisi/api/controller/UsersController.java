package com.mobisi.api.controller;

import com.mobisi.api.dto.AlterUserDto;
import  com.mobisi.api.dto.UserDto;
import com.mobisi.api.exceptions.BaseHttpException;
import com.mobisi.api.responses.ApiResponse;
import com.mobisi.api.responses.DefaultResponse;
import com.mobisi.api.responses.ErrorResponse;
import com.mobisi.api.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse> GetUser(
            @RequestParam(required = false) String email
    ) {
        try {
            List<UserDto> users;

            if (email != null) {
                users = this.usersService.GetByEmail(email);
            } else {
                users = this.usersService.GetAllUsers();
            }

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new DefaultResponse<>(200,users));
        }
        catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> GetById(@PathVariable Long id) {
        try {
            UserDto user = this.usersService.GetById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new DefaultResponse<>(200, user));
        }
        catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> DeleteById(@PathVariable Long id) {
        try {
            this.usersService.DeleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(new DefaultResponse<>(200, null));
        }
        catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> UpdateById(@PathVariable Long id, @RequestBody AlterUserDto alterUser) {
        try {
            this.usersService.UpdateById(id, alterUser);

            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new DefaultResponse<>(200, null));
        }
        catch (BaseHttpException exc) {
            return ResponseEntity.status(exc.getStatusCode())
                    .body(new ErrorResponse(exc.getStatusCode(), exc.getMessage()));
        }
    }
}
