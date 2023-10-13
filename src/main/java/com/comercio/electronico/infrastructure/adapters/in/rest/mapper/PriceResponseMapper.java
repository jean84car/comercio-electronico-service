package com.comercio.electronico.infrastructure.adapters.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.comercio.electronico.domain.Price;
import com.comercio.electronico.infrastructure.adapters.in.rest.controller.response.PriceResponse;

@Mapper(componentModel = "spring")
public interface PriceResponseMapper {

	@Mapping(target = "code", ignore = true)	
	@Mapping(target = "message", ignore = true)
	@Mapping(target = "applicationDate", ignore = true)
	public PriceResponse toResponse(Price domain);
	
}
