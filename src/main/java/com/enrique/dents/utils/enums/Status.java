package com.enrique.dents.utils.enums;

/**
 * ENUMERACIÓN ESTABLECE LOS ESTATUS QUE RESPONDEN LOS END PONT RELACIONADOS CON
 * EL USUAIO
 * 
 * @author Jose Enrique Vergara
 *
 */
public enum Status {
	_SUCCESS(1, "SUCCESS"), _THERE_IS_ALREADY_A_USER(2, "THERE IS ALREADY A USER"),
	_TYPE_USER_NOT_FOUND(3, "TYPE USER NOT FOUND"), _PROFILE_NOT_FOUND(4, "PROFILE NOT FOUND"),
	_CONSULTING_ROOMS_NOT_FOUND(5, "CONSULTING ROOMS NOT FOUND"), _USER_NOT_FOUND(6, "USER NOT FOUND"),
	_INCORRECT_PASSWORD(7, "INCORRECT PASSWORD"), _CIVIL_STATUS_NOT_FOUND(8, "CIVIL STATUS NOT FOUND"), _UPDATED(9, "UPDATED"), _DOCTOR_NOT_FOUND(10, "DOCTOR NOT FOUND"),
	_MEETING_CATEGORY_NOT_FOUND(11, "MEETING CATEGORY NOT FOUND"),_PATIENT_NOT_FOUND(12, "PATIENT NOT FOUND"),_TYPE_MEETINGS(13, "TYPE MEETINGS NOT FOUND");
	private final int id;
	private final String descripcion;

	private Status(final int id, final String descripcion) {
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
