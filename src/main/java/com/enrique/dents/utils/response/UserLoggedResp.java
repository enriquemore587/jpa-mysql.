package com.enrique.dents.utils.response;

public class UserLoggedResp {
	private Long id;
	private String token;
	private Long profileId;
	private String profileName;
	private Long typeUserId;
	private String typeUserName;
	private Long consultingRoomsId;
	private String consultingRoomsName;
	
	private Integer level;

	public UserLoggedResp() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public Long getTypeUserId() {
		return typeUserId;
	}

	public void setTypeUserId(Long typeUserId) {
		this.typeUserId = typeUserId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getTypeUserName() {
		return typeUserName;
	}

	public void setTypeUserName(String typeUserName) {
		this.typeUserName = typeUserName;
	}

	public Long getConsultingRoomsId() {
		return consultingRoomsId;
	}

	public void setConsultingRoomsId(Long consultingRoomsId) {
		this.consultingRoomsId = consultingRoomsId;
	}

	public String getConsultingRoomsName() {
		return consultingRoomsName;
	}

	public void setConsultingRoomsName(String consultingRoomsName) {
		this.consultingRoomsName = consultingRoomsName;
	}

	@Override
	public String toString() {
		return "UserLoggedResp [id=" + id + ", token=" + token + ", profileId=" + profileId + ", typeUserId="
				+ typeUserId + "]";
	}

}
