package com.enrique.dents.utils.response;

/**
 * @author Jose Enrique Vergara
 *
 */
public class TypeUserList {
	private Long id;
	private String description;

	public TypeUserList(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
