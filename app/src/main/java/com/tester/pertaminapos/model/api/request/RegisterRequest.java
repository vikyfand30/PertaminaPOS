package com.tester.pertaminapos.model.api.request;

public class RegisterRequest{
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
//			"RegisterRequest{" +
//			"password = '" + password + '\'' +
//			",email = '" + email + '\'' +
//			"}";
//		}
}
