package com.reworked.utils;

import lombok.Data;

@Data
public class UserDto {

    private Long userId;
    private String username;
    private String roles;


    public UserDto(Long userId, String username, String roles) {
        this.userId = userId;
        this.username = username;
        this.roles = roles;
    }
}
