package com.zenvofurniture.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String message;
    private String userName;
}