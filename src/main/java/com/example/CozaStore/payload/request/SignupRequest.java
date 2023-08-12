package com.example.CozaStore.payload.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SignupRequest {

    @NotNull(message = "Username must not null")

    @NotEmpty(message = "Username not empty")
    private String username;
    @NotNull(message = "Email must not null")

    @NotEmpty(message = "Password not empty")
    @Length(min = 8 , message = "password must have 8 digit")
    private String password;

    @NotNull(message = "Email must not null")
    @NotEmpty(message = "Email not empty")
    @Email(message = "Email invalid format" ,regexp = "^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
