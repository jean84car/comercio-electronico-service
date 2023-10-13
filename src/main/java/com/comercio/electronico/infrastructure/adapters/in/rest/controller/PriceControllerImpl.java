package com.comercio.electronico.infrastructure.adapters.in.rest.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercio.electronico.domain.Price;
import com.comercio.electronico.infrastructure.adapters.in.rest.controller.response.BaseResponse;
import com.comercio.electronico.infrastructure.adapters.in.rest.controller.response.PriceResponse;
import com.comercio.electronico.infrastructure.adapters.in.rest.mapper.PriceResponseMapper;
import com.comercio.electronico.infrastructure.ports.in.rest.PriceController;
import com.comercio.electronico.infrastructure.ports.in.usecase.price.FindBrandProductPriceUseCase;

@RestController
@RequestMapping("api/v1/price")
public class PriceControllerImpl extends GenericController implements PriceController {
	
	private FindBrandProductPriceUseCase findBrandProductPriceUseCase; 
	private PriceResponseMapper priceResponseMapper;
	
	public PriceControllerImpl(FindBrandProductPriceUseCase findBrandProductPriceUseCase, PriceResponseMapper priceResponseMapper) {
		this.findBrandProductPriceUseCase = findBrandProductPriceUseCase;
		this.priceResponseMapper = priceResponseMapper;
	}

	@Override
	public ResponseEntity<BaseResponse> findBrandProductPrice(LocalDateTime applicationDate, BigInteger productoId, Integer brandId) {		
		Price price = findBrandProductPriceUseCase.findBrandProductPrice(applicationDate, productoId, brandId);
		PriceResponse response = priceResponseMapper.toResponse(price);
		response.setApplicationDate(applicationDate);
		return super.ok(response);
	}

}
