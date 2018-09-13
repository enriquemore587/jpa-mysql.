package com.enrique.dents.utils.response;

/**
 * @author Jose Enrique Vergara
 *
 */
public class UserList {
	private String user_name;
	private String password;

	public UserList(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String description) {
		this.password = description;
	}

}
