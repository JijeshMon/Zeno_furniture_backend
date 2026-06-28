package com.zenvofurniture.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zenvofurniture.dto.request.LoginRequest;
import com.zenvofurniture.dto.response.LoginResponse;
import com.zenvofurniture.entity.UserEntity;
import com.zenvofurniture.repository.LoginRepository;
import com.zenvofurniture.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

private final LoginRepository loginRepository;
private final PasswordEncoder passwordEncoder;
private final JwtUtil jwtUtil;
	
	@Override
	public String saveLogin(LoginRequest loginRequest) {
		Optional<UserEntity> user =
	            loginRepository.findByUserName(loginRequest.getUserName());

	    if (user.isPresent()) {
	        throw new RuntimeException("Username already exists");
	    }
		UserEntity entity = new UserEntity();
		entity.setUserName(loginRequest.getUserName());
		entity.setPassword( passwordEncoder.encode(loginRequest.getPassword()));
		loginRepository.save(entity);
		 return "User Registered Successfully";
	}
	@Override
	public LoginResponse login(LoginRequest request) {
	    Optional<UserEntity> userOptional = loginRepository.findByUserName(request.getUserName());
	    
	    if (userOptional.isEmpty()) {
	        LoginResponse response = new LoginResponse();
	        response.setMessage("User not found");
	        response.setToken(null);
	        response.setUserName(null);
	        return response;
	    }
	    
	    UserEntity user = userOptional.get();
	    
	    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	        LoginResponse response = new LoginResponse();
	        response.setMessage("Password mismatch");
	        response.setToken(null);
	        response.setUserName(null);
	        return response;
	    }
	    
	    String token = jwtUtil.generateToken(request.getUserName());
	    
	    LoginResponse response = new LoginResponse();
	    response.setToken(token);
	    response.setMessage("Login Success");
	    response.setUserName(request.getUserName());
	    
	    return response;
	}
}
