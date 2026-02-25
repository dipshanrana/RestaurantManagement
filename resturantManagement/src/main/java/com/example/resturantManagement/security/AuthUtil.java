package com.example.resturantManagement.security;


import com.example.resturantManagement.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    public String generateAccessToken(User user){
        return Jwts.builder().setSubject(user.getUsername()).claim("UserId",user.getId().toString()).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+1000*60*1000)).signWith(getSecretKey()).compact();
    }

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
