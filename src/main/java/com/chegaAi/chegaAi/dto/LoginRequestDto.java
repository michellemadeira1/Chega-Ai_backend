package com.chegaAi.chegaAi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    
    public LoginRequestDto() {}
    
	public LoginRequestDto(@Email @NotBlank String email, @NotBlank String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

    
}

