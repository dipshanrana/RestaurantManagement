package com.example.resturantManagement.controller;


import com.example.resturantManagement.dto.LoginRequestDto;
import com.example.resturantManagement.dto.LoginResponseDto;
import com.example.resturantManagement.dto.SignupRequestDto;
import com.example.resturantManagement.dto.SignupResponseDto;
import com.example.resturantManagement.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
    return ResponseEntity.ok().body(authService.login(loginRequestDto));
    }

   @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto){
        return ResponseEntity.ok().body(authService.signupInternal(signupRequestDto));
    }
}
