package com.comercio.electronico.infrastructure.ports.out.database.price;

public class PricePortNotFoundException  extends RuntimeException {

	private static final long serialVersionUID = -6858983513255433298L;
	
	public PricePortNotFoundException(String message) {
		super(message);
	}

}
