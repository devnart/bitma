package com.hamza.bitma.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.hamza.bitma.dto.model.UserDto;
import com.hamza.bitma.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) throws Exception {
        return authService.register(userDto);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public String login(@RequestParam String idToken) throws FirebaseAuthException {
        System.out.println("idToken from controller: " + idToken);
        return authService.login(idToken);
    }
}
