package ua.svp.securityjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponseDto {

    private String username;
    private String email;
    private Collection<String> roles;

}