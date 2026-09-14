package com.finance.backend.service;

import com.finance.backend.dto.request.LoginRequest;
import com.finance.backend.dto.request.RegisterRequest;
import com.finance.backend.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse login(LoginRequest request);
}