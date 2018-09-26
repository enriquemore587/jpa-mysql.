package com.enrique.dents.utils.enums;

/**
 * ENUMERACIÓN ESTABLECE LOS ESTATUS QUE RESPONDEN LOS END PONT RELACIONADOS CON
 * EL USUAIO
 * 
 * @author Jose Enrique Vergara
 *
 */
public enum Constants {
	_NO_DATA(1, "NO DATA"),
	_ERROR_DATE_FORMAT(2, "ERROR DATE FORMAT"),
	_INFORMATION_NOT_STORED(3, "INFORMATION NOT STORED");
	
	private final int id;
	private final String descripcion;

	private Constants(final int id, final String descripcion) {
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
