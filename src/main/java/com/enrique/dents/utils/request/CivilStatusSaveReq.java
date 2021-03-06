package com.enrique.dents.utils.request;

/**
 * @author Jose Enrique Vergara
 *
 */
public class CivilStatusSaveReq {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean okData() {
		return this.description != "" && this.description != null ? false : true;
	}

	@Override
	public String toString() {
		return "CivilStatusSaveReq [description=" + description + "]";
	}

}
