package com.enrique.dents.utils.response;

/**
 * @author Jose Enrique Vergara
 *
 */
public class GenericSuccesResp {
	private String status;
	private String message;

	public GenericSuccesResp(String status, String msg) {
		this.status = status;
		this.message = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
