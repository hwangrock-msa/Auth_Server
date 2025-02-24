package com.example.authserver.controller;

import com.example.authserver.dto.request.LoginRequestDTO;
import com.example.authserver.dto.response.LoginResponseDTO;
import com.example.authserver.dto.response.ResponseDto;
import com.example.authserver.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("api/v1"))
public class AuthController {

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

