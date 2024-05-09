package com.security.sec.service;

import com.security.sec.model.AuthResponse;
import com.security.sec.model.LoginRequest;
import com.security.sec.model.SignUpRequest;

public interface AuthService {
	AuthResponse login(LoginRequest loginRequest);
	String registerUser(SignUpRequest signUpRequest);
}
