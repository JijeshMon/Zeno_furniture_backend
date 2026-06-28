package com.zenvofurniture.services;

import com.zenvofurniture.dto.request.LoginRequest;
import com.zenvofurniture.dto.response.LoginResponse;

public interface LoginService {

	public String saveLogin(LoginRequest loginRequest);
	public LoginResponse login(LoginRequest loginRequest);
}
