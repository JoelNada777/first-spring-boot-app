package com.first.myfirstapp.controller;

import com.first.myfirstapp.models.DTO.JWTAuthResponse;
import com.first.myfirstapp.models.DTO.LoginDTO;
import com.first.myfirstapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        String response = authService.login(loginDTO);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setToken(response);
        return ResponseEntity.ok(jwtAuthResponse);
    }
}
