package com.zenvofurniture.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenvofurniture.dto.request.LoginRequest;
import com.zenvofurniture.dto.response.LoginResponse;
import com.zenvofurniture.services.LoginService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {
private final LoginService loginService;
	
	@PostMapping("/addUser")
	public String addLogin(@RequestBody LoginRequest loginRequest) {
		loginService.saveLogin(loginRequest);
		return "user added";
	}
	
	@PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
	
	 
}
