package com.security.sec.serviceIpml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.sec.config.TokenProvider;
import com.security.sec.exception.BadRequestException;
import com.security.sec.model.AuthResponse;
import com.security.sec.model.LoginRequest;
import com.security.sec.model.SignUpRequest;
import com.security.sec.model.Usuario;
import com.security.sec.repository.UsuarioRepository;
import com.security.sec.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Autowired UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public AuthResponse login(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = tokenProvider.createToken(authentication);
		
		Usuario userPrincipal = (Usuario) authentication.getPrincipal();
		
		AuthResponse authresponse = new AuthResponse();
		authresponse.setAccessToken(token);
		authresponse.setUserId(userPrincipal.getUsuarioId());
		authresponse.setUsuername(userPrincipal.getUserName());
		
		return authresponse;
	}
	
	@Override
	public String registerUser(SignUpRequest signUpRequest) {
		if (usuarioRepository.existsByUserName(signUpRequest.getNombre())) {
			throw new BadRequestException("The user is alredy exist!");
		}

		Usuario user = new Usuario();
		user.setUserName(signUpRequest.getUsername());
		user.setEmail(signUpRequest.getEmail());
		user.setNombre(signUpRequest.getNombre());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

		usuarioRepository.save(user);

		return "User created successfully";
	}

}
