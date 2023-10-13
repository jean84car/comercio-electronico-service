package com.comercio.electronico.infrastructure.ports.in.usecase.price;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.comercio.electronico.domain.Price;

@FunctionalInterface
public interface FindBrandProductPriceUseCase {

	public Price findBrandProductPrice(LocalDateTime date, BigInteger productoId, Integer brandId);
	
}
