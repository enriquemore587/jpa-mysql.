package com.enrique.dents.utils.request;

public class UserPersonalDataSaveReq {
	private String name;
	private String last_name;
	private String last_name2;
	private String phone_number;
	private String mobile_phone_number;
	private String gender;
	private String birthdate;
	private String important_note;
	private Long userId;
	private Long civilStatusId;
	
	public boolean okData() {
		return 
				this.name != "" && this.name != null
						&& this.last_name != "" && this.last_name != null
								&& this.last_name2 != "" && this.last_name2 != null
										&& this.phone_number != "" && this.phone_number != null
												&& this.mobile_phone_number != "" && this.mobile_phone_number != null
														&& this.gender != "" && this.gender != null
																&& this.birthdate != "" && this.birthdate != null
																		&& this.important_note != "" && this.important_note != null
																				&& this.userId != null && this.userId > 0l
																						&& this.civilStatusId != null && this.civilStatusId > 0l
				? false : true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getLast_name2() {
		return last_name2;
	}
	public void setLast_name2(String last_name2) {
		this.last_name2 = last_name2;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getMobile_phone_number() {
		return mobile_phone_number;
	}
	public void setMobile_phone_number(String mobile_phone_number) {
		this.mobile_phone_number = mobile_phone_number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getImportant_note() {
		return important_note;
	}
	public void setImportant_note(String important_note) {
		this.important_note = important_note;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCivilStatusId() {
		return civilStatusId;
	}
	public void setCivilStatusId(Long civilStatusId) {
		this.civilStatusId = civilStatusId;
	}	
	
}
