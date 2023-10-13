package com.comercio.electronico.infrastructure.adapters.out.database.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.comercio.electronico.domain.Price;
import com.comercio.electronico.infrastructure.adapters.out.database.entity.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

	public Price toDomain(PriceEntity entity);
	
	public List<Price> toDomains(List<PriceEntity> entities);
	
}
