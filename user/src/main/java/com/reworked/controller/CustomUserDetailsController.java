package com.reworked.controller;

import com.reworked.dto.UserDto;
import com.reworked.security.CustomUserDetailsService;
import com.reworked.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class CustomUserDetailsController {

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/{jwtToken}")
    public ResponseEntity<UserDto> getAuth(@PathVariable String jwtToken) {
        try{
            Long userId = tokenProvider.getUserIdFromJWT(jwtToken);

            UserDetails userDetails = customUserDetailsService.loadUserById(userId);

            UserDto dto = new UserDto(userId, userDetails.getUsername());

            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
