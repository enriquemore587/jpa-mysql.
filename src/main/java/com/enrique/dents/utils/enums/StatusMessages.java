package com.enrique.dents.utils.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jose Enrique Vergara
 *
 */
public enum StatusMessages {
	_SUCCESS_STATUS(1, "SUCCESS"), _MISSING_PARAMS_STATUS(2, "MISSING PARAMS"),
	_MISSING_PARAMS_MSG(3, "MISSING PARAMS"), _SAVED_MSG(4, "SAVED"), _UPDATED_MSG(5, "UPDATED");
	private final int id;
	private final String descripcion;

	private StatusMessages(final int id, final String descripcion) {
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
		for (StatusMessages item : values()) {
			l.add(item.descripcion);
		}
		return l;
	}
}
