package com.finance.backend.service.impl;

import com.finance.backend.dto.request.LoginRequest;
import com.finance.backend.dto.request.RegisterRequest;
import com.finance.backend.dto.response.AuthenticationResponse;
import com.finance.backend.entity.User;
import com.finance.backend.repository.UserRepository;
import com.finance.backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;


    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already Exits");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        User saved = userRepository.save(user);

        log.info("New user Registered:{}",saved.getEmail());

        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .message("Registration Successful")
                .build();
    }

    public AuthenticationResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found."));


        if(!user.getPassword().equals(request.getPassword())){
            throw new  RuntimeException("Invalid Password");
        }

        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .message("Login Successful")
                .build();
    }

}
