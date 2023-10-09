package com.medicine.application;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class LoginPersonData {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min=8,max=16)
    private String password;


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Person(Email: " + this.email + ", Password: " + this.password + ")";
    }


}
