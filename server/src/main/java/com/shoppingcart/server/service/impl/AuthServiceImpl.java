package com.shoppingcart.server.service.impl;

import com.shoppingcart.server.dao.request.RegisterRequest;
import com.shoppingcart.server.dao.request.SigninRequest;
import com.shoppingcart.server.dao.response.JwtAuthenticationResponse;
import com.shoppingcart.server.entity.UserEntity;
import com.shoppingcart.server.model.User;
import com.shoppingcart.server.repository.UserRepository;
import com.shoppingcart.server.service.AuthService;
import com.shoppingcart.server.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse registerNewUser(RegisterRequest registerRequest) {
        UserEntity user = UserEntity.builder().firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName()).email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword())).build();
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse login(SigninRequest signinRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        var user = userRepository.findByEmail(signinRequest.getEmail())
                .orElseThrow(()-> new IllegalArgumentException("invalid email or password"));
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

}
