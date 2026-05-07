package com.proyecto.web.user.controller;

import com.proyecto.web.user.dto.request.UserCreateRequest;
import com.proyecto.web.user.dto.response.UserResponse;
import com.proyecto.web.user.dto.request.UserUpdateRequest;
import com.proyecto.web.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {

        UserResponse userResponse =  userService.registerUser(userCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
                                                   @Valid @RequestBody UserUpdateRequest userUpdateRequest) {

        UserResponse userResponse = userService.updateUser(userUpdateRequest);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return ResponseEntity.notFound().build();
    }
}