package com.example.springform.model;

import com.example.springform.validation.NameValidation;
import jakarta.validation.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class User {

    @NotEmpty(message = "Name is required")
//    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must only contains letters and spaces")
    @NameValidation(message = "Name must only contains letters and spaces")
    private String name;

    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$", message = "Invalid email format")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
