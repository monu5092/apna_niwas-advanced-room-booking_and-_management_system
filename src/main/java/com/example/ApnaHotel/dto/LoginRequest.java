package com.example.ApnaHotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class LoginRequest {

    @NotNull(message = "Email is required")
    private String email;
     @NotNull(message = "Password is required")
    private String password;

}
