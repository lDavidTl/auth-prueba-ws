package com.security.sec.model;

public class AuthResponse {
	private String accessToken;
	private String usuername;
	private Long userId;
	private String tokenType = "Bearer";

	
	public String getUsuername() {
		return usuername;
	}

	public void setUsuername(String usuername) {
		this.usuername = usuername;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public AuthResponse(String accessToken) {
		this.accessToken = accessToken;
	}

	public AuthResponse() {
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}
