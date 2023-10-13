package com.comercio.electronico.infrastructure.adapters.in.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.comercio.electronico.domain.enums.MessageCodeEnum;
import com.comercio.electronico.infrastructure.adapters.in.rest.controller.response.BaseResponse;
import com.comercio.electronico.infrastructure.ports.in.usecase.price.PriceNoSuchElementException;
import com.comercio.electronico.infrastructure.ports.out.database.price.PricePortException;
import com.comercio.electronico.infrastructure.ports.out.database.price.PricePortNotFoundException;



@RestControllerAdvice
public class EcommerceExceptionHandler {

	@ExceptionHandler({PriceNoSuchElementException.class, PricePortNotFoundException.class})
	public ResponseEntity<BaseResponse> handleException(RuntimeException e) {
		BaseResponse responseError = new BaseResponse();
		responseError.setCode(MessageCodeEnum.E098.name());
		responseError.setMessage(e.getMessage());
		return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PricePortException.class)
	public ResponseEntity<BaseResponse> handleException(PricePortException e) {
		BaseResponse responseError = new BaseResponse();
		responseError.setCode(MessageCodeEnum.E099.name());
		responseError.setMessage(e.getMessage());
		return new ResponseEntity<>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
