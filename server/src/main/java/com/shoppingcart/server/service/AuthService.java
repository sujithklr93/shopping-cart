package com.shoppingcart.server.service;

import com.shoppingcart.server.dao.request.RegisterRequest;
import com.shoppingcart.server.dao.request.SigninRequest;
import com.shoppingcart.server.dao.response.JwtAuthenticationResponse;

public interface AuthService {
    JwtAuthenticationResponse registerNewUser(RegisterRequest registerRequest);
    JwtAuthenticationResponse login(SigninRequest signinRequest);
}
