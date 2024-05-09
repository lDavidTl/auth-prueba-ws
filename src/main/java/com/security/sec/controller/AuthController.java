package com.security.sec.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.sec.model.LoginRequest;
import com.security.sec.model.SignUpRequest;
import com.security.sec.service.AuthService;

import jakarta.validation.Valid;
import utils.ResponseFormat;

@RestController
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@PostMapping("login")
	public ResponseEntity<Map<String, Object>> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return ResponseFormat.successEntity(authService.login(loginRequest));
	}
	
	@PostMapping("signup")
	public  ResponseEntity<Map<String, Object>> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		return ResponseFormat.successEntity(authService.registerUser(signUpRequest));
	}

}
