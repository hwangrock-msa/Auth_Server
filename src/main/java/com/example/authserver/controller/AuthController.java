package com.example.authserver.controller;

import com.example.authserver.dto.request.LoginRequestDTO;
import com.example.authserver.dto.response.LoginResponseDTO;
import com.example.authserver.dto.response.ResponseDto;
import com.example.authserver.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("api/v1/auth"))
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginRequestDTO dto){
        String token=authService.tokenProvider(dto);

        LoginResponseDTO ans=LoginResponseDTO.builder()
                .accessToken(token)
                .build();
        return ResponseEntity.ok(new ResponseDto<>(ans));
    }

}

