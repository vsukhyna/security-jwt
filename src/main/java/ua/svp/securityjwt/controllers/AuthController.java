package ua.svp.securityjwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.svp.securityjwt.dto.JwtRequestDto;
import ua.svp.securityjwt.dto.RegistrationDto;
import ua.svp.securityjwt.exceptions.AppErrorDto;
import ua.svp.securityjwt.services.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequestDto request) {
        try {
            return ResponseEntity.ok(authService.createAuthToken(request));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(
                    new AppErrorDto("Login or password is not valid"), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok("User created: " + authService.createUser(dto));
    }
}
