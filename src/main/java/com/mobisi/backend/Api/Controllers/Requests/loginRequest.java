package com.mobisi.backend.Api.Controllers.Requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class loginRequest {
    private String email;
    private String senha;

    public loginRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
