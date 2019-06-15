package com.tester.pertaminapos.model.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import app.beelabs.com.codebase.base.response.BaseResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForgotPasswordResponse extends BaseResponse {
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
			"ForgotPasswordResponse{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Data{
		private Object activationCode;
		private String lastLogin;
		private String active;
		private Object lastName;
		private String ipAddress;
		private Object forgottenPasswordSelector;
		private String password;
		private Object rememberSelector;
		private Object forgottenPasswordTime;
		private String createdOn;
		private Object phone;
		private String userId;
		private Object activationSelector;
		private Object rememberCode;
		private Object company;
		private String id;
		private Object firstName;
		private String email;
		private Object forgottenPasswordCode;
		private String username;

		public void setActivationCode(Object activationCode){
			this.activationCode = activationCode;
		}

		public Object getActivationCode(){
			return activationCode;
		}

		public void setLastLogin(String lastLogin){
			this.lastLogin = lastLogin;
		}

		public String getLastLogin(){
			return lastLogin;
		}

		public void setActive(String active){
			this.active = active;
		}

		public String getActive(){
			return active;
		}

		public void setLastName(Object lastName){
			this.lastName = lastName;
		}

		public Object getLastName(){
			return lastName;
		}

		public void setIpAddress(String ipAddress){
			this.ipAddress = ipAddress;
		}

		public String getIpAddress(){
			return ipAddress;
		}

		public void setForgottenPasswordSelector(Object forgottenPasswordSelector){
			this.forgottenPasswordSelector = forgottenPasswordSelector;
		}

		public Object getForgottenPasswordSelector(){
			return forgottenPasswordSelector;
		}

		public void setPassword(String password){
			this.password = password;
		}

		public String getPassword(){
			return password;
		}

		public void setRememberSelector(Object rememberSelector){
			this.rememberSelector = rememberSelector;
		}

		public Object getRememberSelector(){
			return rememberSelector;
		}

		public void setForgottenPasswordTime(Object forgottenPasswordTime){
			this.forgottenPasswordTime = forgottenPasswordTime;
		}

		public Object getForgottenPasswordTime(){
			return forgottenPasswordTime;
		}

		public void setCreatedOn(String createdOn){
			this.createdOn = createdOn;
		}

		public String getCreatedOn(){
			return createdOn;
		}

		public void setPhone(Object phone){
			this.phone = phone;
		}

		public Object getPhone(){
			return phone;
		}

		public void setUserId(String userId){
			this.userId = userId;
		}

		public String getUserId(){
			return userId;
		}

		public void setActivationSelector(Object activationSelector){
			this.activationSelector = activationSelector;
		}

		public Object getActivationSelector(){
			return activationSelector;
		}

		public void setRememberCode(Object rememberCode){
			this.rememberCode = rememberCode;
		}

		public Object getRememberCode(){
			return rememberCode;
		}

		public void setCompany(Object company){
			this.company = company;
		}

		public Object getCompany(){
			return company;
		}

		public void setId(String id){
			this.id = id;
		}

		public String getId(){
			return id;
		}

		public void setFirstName(Object firstName){
			this.firstName = firstName;
		}

		public Object getFirstName(){
			return firstName;
		}

		public void setEmail(String email){
			this.email = email;
		}

		public String getEmail(){
			return email;
		}

		public void setForgottenPasswordCode(Object forgottenPasswordCode){
			this.forgottenPasswordCode = forgottenPasswordCode;
		}

		public Object getForgottenPasswordCode(){
			return forgottenPasswordCode;
		}

		public void setUsername(String username){
			this.username = username;
		}

		public String getUsername(){
			return username;
		}

		@Override
		public String toString(){
			return
					"Data{" +
							"activation_code = '" + activationCode + '\'' +
							",last_login = '" + lastLogin + '\'' +
							",active = '" + active + '\'' +
							",last_name = '" + lastName + '\'' +
							",ip_address = '" + ipAddress + '\'' +
							",forgotten_password_selector = '" + forgottenPasswordSelector + '\'' +
							",password = '" + password + '\'' +
							",remember_selector = '" + rememberSelector + '\'' +
							",forgotten_password_time = '" + forgottenPasswordTime + '\'' +
							",created_on = '" + createdOn + '\'' +
							",phone = '" + phone + '\'' +
							",user_id = '" + userId + '\'' +
							",activation_selector = '" + activationSelector + '\'' +
							",remember_code = '" + rememberCode + '\'' +
							",company = '" + company + '\'' +
							",id = '" + id + '\'' +
							",first_name = '" + firstName + '\'' +
							",email = '" + email + '\'' +
							",forgotten_password_code = '" + forgottenPasswordCode + '\'' +
							",username = '" + username + '\'' +
							"}";
		}
	}
}
