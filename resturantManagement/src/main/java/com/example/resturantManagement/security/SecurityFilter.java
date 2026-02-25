package com.example.resturantManagement.security;

import com.example.resturantManagement.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityFilter {
        private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain SecurityFilter(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        auth->
                                auth.requestMatchers("/public/**","/auth/**").permitAll()
                                        .requestMatchers("/admin/**")
                                        .authenticated().anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

                                 return httpSecurity.build();
    }
}
