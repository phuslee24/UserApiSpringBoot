package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * userDto
 */
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class userDto {
   
    @NotEmpty(message = "HI. User name not empty")
    private String userName;
    @NotEmpty(message = "HI. Password name not empty")
    private String password;
    
}