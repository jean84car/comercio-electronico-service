package com.comercio.electronico.infrastructure.ports.in.usecase.price;

public class PriceNoSuchElementException extends RuntimeException {

	private static final long serialVersionUID = -6858983513255433298L;
	
	public PriceNoSuchElementException(String message) {
		super(message);
	}
	
}
