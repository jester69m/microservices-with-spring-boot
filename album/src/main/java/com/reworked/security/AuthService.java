package com.reworked.security;

import com.reworked.utils.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final RestTemplate restTemplate;

    @Autowired
    public AuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto getCurrentUser(Long id) {
        String microserviceUrl = "http://localhost:8081/api/users/" + id;
        try {
            return restTemplate.getForObject(microserviceUrl, UserDto.class);
        } catch (HttpClientErrorException.NotFound e) {
            // Handle the 404 error here
            // You can log it or take other appropriate actions
            // For example, return a default response or throw a custom exception
            return null;
        }
    }
}
