package com.comercio.electronico.infrastructure.ports.out.database.price;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.comercio.electronico.domain.Price;

@FunctionalInterface
public interface FindBrandProductPricePort {

	public List<Price> findBrandProductPrice(LocalDateTime date, BigInteger productoId, Integer brandId);
	
}
