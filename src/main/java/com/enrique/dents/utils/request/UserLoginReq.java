package com.enrique.dents.utils.request;

public class UserLoginReq {
	private String user_name;
	private String password;
	private Long consulting_room_id;
	private Long profile_id;
	private Long type_user_id;
	private Integer level;

	public UserLoginReq(String user_name, String password) {
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

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getConsulting_room_id() {
		return consulting_room_id;
	}

	public void setConsulting_room_id(Long consulting_room_id) {
		this.consulting_room_id = consulting_room_id;
	}

	public Long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(Long profile_id) {
		this.profile_id = profile_id;
	}

	public Long getType_user_id() {
		return type_user_id;
	}

	public void setType_user_id(Long type_user_id) {
		this.type_user_id = type_user_id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public boolean okData() {
		return this.user_name != null && this.user_name != "" 
				&& this.password != null && this.password != "" 
				? false
				: true;
	}

}
