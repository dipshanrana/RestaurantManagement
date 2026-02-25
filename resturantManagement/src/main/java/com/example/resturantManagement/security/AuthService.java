package com.example.resturantManagement.security;

import com.example.resturantManagement.dto.LoginRequestDto;
import com.example.resturantManagement.dto.LoginResponseDto;
import com.example.resturantManagement.dto.SignupRequestDto;
import com.example.resturantManagement.dto.SignupResponseDto;
import com.example.resturantManagement.model.User;
import com.example.resturantManagement.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@Slf4j
@RequiredArgsConstructor

public class AuthService {
    private final UserRepo userRepo;

    private final AuthUtil authUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword()));
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDto(user.getId(),token);
    }


    public SignupResponseDto signupInternal(SignupRequestDto signupRequestDto) {
        User user = userRepo.findByUsername(signupRequestDto.getUsername());
        if(user != null){
            throw new IllegalArgumentException("username already exists");
        }
        user = User.builder().username(signupRequestDto.getUsername()).password(passwordEncoder.encode(signupRequestDto.getPassword())).build();
        user = userRepo.save(user);
        return modelMapper.map(user,SignupResponseDto.class);
    }
}
