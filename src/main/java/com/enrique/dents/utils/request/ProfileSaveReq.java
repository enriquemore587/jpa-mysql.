package com.enrique.dents.utils.request;

/**
 * @author Jose Enrique Vergara
 *
 */
public class ProfileSaveReq {
	private Integer type;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean okData() {
		return this.type != null && this.type > 0 && this.description != "" && this.description != null ? false : true;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProfileSaveReq [type=" + type + ", description=" + description + "]";
	}

}
