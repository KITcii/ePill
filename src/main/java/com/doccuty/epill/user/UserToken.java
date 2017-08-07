package com.doccuty.epill.user;

/**
 * Return object containing a valid user and his corresponding JWT token.
 */

public class UserToken {

	private SimpleUser user;
	private String token;

	/* user object */
	
	public static final String PROPERTY_USER = "user";
	
	public void setUser(SimpleUser user) {
		this.user = user;
	}
	
	public SimpleUser getUser() {
		return this.user;
	}
	
	/* token string */

	public static final String PROPERTY_TOKEN = "token";
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return this.token;
	}
}
