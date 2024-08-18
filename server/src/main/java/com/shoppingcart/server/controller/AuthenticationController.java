package com.shoppingcart.server.controller;

import com.shoppingcart.server.dao.request.RegisterRequest;
import com.shoppingcart.server.dao.request.SigninRequest;
import com.shoppingcart.server.dao.response.JwtAuthenticationResponse;
import com.shoppingcart.server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> registerNewUser(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.registerNewUser(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody SigninRequest signinRequest){
        System.out.println(signinRequest);
        return ResponseEntity.ok(authService.login(signinRequest));
    }
}
