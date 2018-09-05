package com.enrique.dents.utils.request;

/**
 * @author Jose Enrique Vergara
 *
 */
public class ProfileUpdateReq {
	private Long id;
	private Integer type;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean okData() {
		return this.id != null && this.id > 0 && this.type != null && this.type > 0 && this.description != ""
				&& this.description != null ? false : true;
	}

	public Integer getType() {
		return type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProfileUpdateReq [id=" + id + ", type=" + type + ", description=" + description + "]";
	}

}
