package com.example.spring_boot_jobApp.controller;

import com.example.spring_boot_jobApp.model.RegisterUserRequest;
import com.example.spring_boot_jobApp.model.Role;
import com.example.spring_boot_jobApp.model.UserResponse;
import com.example.spring_boot_jobApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        registerUserRequest.setRole(Role.USER);
        UserResponse response = userService.registerUser(registerUserRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/admin/create")
    @PreAuthorize("hasAuthority('DEMO_WRITE')")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> registerByAdmin(@RequestBody RegisterUserRequest registerUserRequest) {
        UserResponse response = userService.registerUser(registerUserRequest);
        return ResponseEntity.ok(response);
    }
}
