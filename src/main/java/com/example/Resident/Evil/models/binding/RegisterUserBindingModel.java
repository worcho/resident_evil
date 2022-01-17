package com.example.Resident.Evil.models.binding;

import com.example.Resident.Evil.custom.Username;
import com.example.Resident.Evil.custom.isFreeEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterUserBindingModel {

    @NotEmpty(message = "Username name cannot be empty.")
    @Username(message = "This username is already taken.")
    private String username;
    @NotEmpty(message = "Password name cannot be empty.")
    @Size(min=3, message = "Password must be more than 3 symbols")
    private String password;
    private String confirmPassword;
    @Email
    @NotEmpty(message = "Email name cannot be empty.")
    @isFreeEmail(message = "This email is already taken.")
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
