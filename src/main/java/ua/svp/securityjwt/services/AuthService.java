package ua.svp.securityjwt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.svp.securityjwt.dto.JwtRequestDto;
import ua.svp.securityjwt.dto.JwtResponseDto;
import ua.svp.securityjwt.dto.RegistrationDto;
import ua.svp.securityjwt.models.Role;
import ua.svp.securityjwt.models.User;
import ua.svp.securityjwt.utils.JwtTokenUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final RoleService roleService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public JwtResponseDto createAuthToken(JwtRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return new JwtResponseDto(token);
    }

    public UUID createUser(RegistrationDto dto) {

        User userForSave = new User();
        userForSave.setUsername(dto.getUsername());
        userForSave.setEmail(dto.getEmail());
        userForSave.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userService.saveUser(userForSave);
    }
}
