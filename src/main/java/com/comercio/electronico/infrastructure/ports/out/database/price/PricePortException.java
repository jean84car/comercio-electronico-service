package com.comercio.electronico.infrastructure.ports.out.database.price;

public class PricePortException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2190012667396136630L;
	
	public PricePortException(String message) {
		super(message);
	}

	public PricePortException(String message, Throwable cause) {
		super(message, cause);
	}

	
}
