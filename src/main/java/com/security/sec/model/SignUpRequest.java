package com.security.sec.model;

import jakarta.validation.constraints.NotBlank;

public class SignUpRequest {
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public SignUpRequest(@NotBlank String nombre, @NotBlank String username, @NotBlank String email,
			@NotBlank String password) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public SignUpRequest() {
		super();
	}
	
	
	
}
