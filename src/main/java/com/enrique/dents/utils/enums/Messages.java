package com.enrique.dents.utils.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jose Enrique Vergara
 *
 */
public enum Messages {
	_SUCCESS_STATUS(1, "SUCCESS"), _MISSING_PARAMS_STATUS(2, "MISSING PARAMS"),
	_MISSING_PARAMS_MSG(3, "MISSING PARAMS"), _SAVED_MSG(4, "SAVED"), _UPDATED_MSG(5, "UPDATED"),
	_UNREGISTERED_USER(6, "UNREGISTERED USER"),_USER_NOT_FOUND(7, "EL USUARIO NO EXISTE"),_INCORRECT_PASSWORD(8, "CONTRASEÑA INCORRECTA"),
	_UNREGISTERED_USER_PERSONAL_DATA(9, "UNREGISTERED USER PERSONAL DATA"),_USER_PERSONAL_DATA_COMPLETE(10, "USER PERSONAL DATA COMPLETE"),_USER_PERSONAL_DATA_INCOMPLETE(11, "USER PERSONAL DATA INCOMPLETE"),
	_USER_ADDRESS_INCOMPLETE(12, "USER ADDRESS INCOMPLETE"),
	_USER_ADDRESS(13, "USER ADDRESS");
	private final int id;
	private final String descripcion;

	private Messages(final int id, final String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static List<String> obtenerTodosDescripcion() {
		List<String> l = new ArrayList<String>();
		for (Messages item : values()) {
			l.add(item.descripcion);
		}
		return l;
	}
}
