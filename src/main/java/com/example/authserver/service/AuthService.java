package com.example.authserver.service;

import com.example.authserver.dto.request.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtProvider jwt;

    public String tokenProvider(LoginRequestDTO dto){

        Long userId=dto.getId();
        String email=dto.getEmail();

        String acessToken=jwt.createAccessToken(userId,email);

        return acessToken;
    }
}
