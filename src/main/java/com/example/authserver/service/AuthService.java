package com.example.authserver.service;

import com.example.authserver.dto.request.LoginRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String tokenProvider(LoginRequestDTO dto){
        String token="";

        Long userId=dto.getId();
        String email=dto.getEmail();

        return token;
    }
}
