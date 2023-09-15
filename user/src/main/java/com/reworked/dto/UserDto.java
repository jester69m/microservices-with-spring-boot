package com.reworked.dto;

public class UserDto {

    private Long userId;
    private String username;


    public UserDto(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}
