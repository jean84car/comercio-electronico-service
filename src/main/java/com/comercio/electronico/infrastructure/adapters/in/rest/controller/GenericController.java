package com.comercio.electronico.infrastructure.adapters.in.rest.controller;

import org.springframework.http.ResponseEntity;

import com.comercio.electronico.domain.enums.MessageCodeEnum;
import com.comercio.electronico.infrastructure.adapters.in.rest.controller.response.BaseResponse;


public abstract class GenericController {

	protected ResponseEntity<BaseResponse> ok(BaseResponse response) {
		response.setCode(MessageCodeEnum.I000.name());
		return ResponseEntity.ok(response);
	}
	
	
}
