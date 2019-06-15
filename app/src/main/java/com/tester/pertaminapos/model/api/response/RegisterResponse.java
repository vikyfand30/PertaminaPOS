package com.tester.pertaminapos.model.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import app.beelabs.com.codebase.base.response.BaseResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterResponse extends BaseResponse {
	private int code;
	private Data data;
	private String message;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"RegisterResponse{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Data{
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

		@Override
		public String toString(){
			return
					"Data{" +
							"password = '" + password + '\'' +
							",email = '" + email + '\'' +
							"}";
		}
	}

}
