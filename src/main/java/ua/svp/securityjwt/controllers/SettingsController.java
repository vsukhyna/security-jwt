package ua.svp.securityjwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.svp.securityjwt.dto.UserProfileResponseDto;
import ua.svp.securityjwt.services.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/settings")
@RequiredArgsConstructor
public class SettingsController {

    private final UserService userService;

    @GetMapping("/users-list")
    public List<UserProfileResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/user-delete/{userId}")
//    public ResponseEntity<?> deleteUser(@PathVariable("userId") UUID userId) {
//        userService.deleteUser(userId);
//        return ResponseEntity.ok("Deleted");
//    }

}