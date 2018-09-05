package com.enrique.dents.utils.enums;

/**
 * @author Jose Enrique Vergara
 *
 */
public enum StatusUsers {
	_SUCCESS(1, "SUCCESS"), 
	_THERE_IS_ALREADY_A_USER(2, "THERE IS ALREADY A USER"),
	_TYPE_USER_NOT_FOUND(3, "TYPE USER NOT FOUND"),
	_PROFILE_NOT_FOUND(4, "PROFILE NOT FOUND"),
	_CONSULTING_ROOMS_NOT_FOUND(5, "CONSULTING ROOMS NOT FOUND");
	private final int id;
	private final String descripcion;

	private StatusUsers(final int id, final String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
