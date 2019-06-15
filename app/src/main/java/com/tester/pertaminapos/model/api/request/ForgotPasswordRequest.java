package com.tester.pertaminapos.model.api.request;

public class ForgotPasswordRequest{
	private String identity;

	public void setIdentity(String identity){
		this.identity = identity;
	}

	public String getIdentity(){
		return identity;
	}

	@Override
 	public String toString(){
		return 
			"ForgotPasswordRequest{" + 
			"identity = '" + identity + '\'' + 
			"}";
		}
}
