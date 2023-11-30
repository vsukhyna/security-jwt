package ua.svp.securityjwt.dto;

import lombok.Data;

@Data
public class RegistrationDto {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
