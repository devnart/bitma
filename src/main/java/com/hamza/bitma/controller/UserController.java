package com.hamza.bitma.controller;

import com.hamza.bitma.dto.model.UserDto;
import com.hamza.bitma.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        return userService.save(user);
    }

    @GetMapping("/all")
    public Iterable<UserDto> getAllUsers() {
        return userService.findAll();
    }
}
