package ua.svp.securityjwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.svp.securityjwt.dto.UserProfileResponseDto;
import ua.svp.securityjwt.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping(path = "/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserProfileResponseDto> getCurrentProfile(Principal principal) {

        UserProfileResponseDto response = userService.getUserProfile(principal.getName());

        return ResponseEntity.ok(response);
    }
}
