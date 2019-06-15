package com.tester.pertaminapos.model.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest{
	private String password;
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

//	@Override
// 	public String toString(){
//		return
//			"LoginRequest{" +
//			"password = '" + password + '\'' +
//			",email = '" + email + '\'' +
//			"}";
//		}
}
