package com.comercio.electronico.infrastructure.adapters.out.database;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.comercio.electronico.application.configuration.MessageProperty;
import com.comercio.electronico.domain.Price;
import com.comercio.electronico.domain.enums.MessageCodeEnum;
import com.comercio.electronico.infrastructure.adapters.out.database.entity.PriceEntity;
import com.comercio.electronico.infrastructure.adapters.out.database.mapper.PriceEntityMapper;
import com.comercio.electronico.infrastructure.adapters.out.database.repository.PriceRepository;
import com.comercio.electronico.infrastructure.ports.out.database.price.FindBrandProductPricePort;
import com.comercio.electronico.infrastructure.ports.out.database.price.PricePortException;
import com.comercio.electronico.infrastructure.ports.out.database.price.PricePortNotFoundException;

@Component
public class PriceDatabaseAdapter implements FindBrandProductPricePort {
	
	private static final Logger LOG = LoggerFactory.getLogger(PriceDatabaseAdapter.class);

	private PriceRepository priceRepository;
	private MessageProperty messageProperty;
	private PriceEntityMapper priceMapper;
	
	public PriceDatabaseAdapter(PriceRepository priceRepository, MessageProperty messageProperty, PriceEntityMapper priceMapper) {
		this.priceRepository = priceRepository;
		this.messageProperty = messageProperty;
		this.priceMapper = priceMapper;
	}
	
	@Override
	public List<Price> findBrandProductPrice(LocalDateTime date, BigInteger productoId, Integer brandId) {
		try {
			List<PriceEntity> entities = priceRepository.findByBrandAndProduct(brandId, productoId, date);
			if(entities == null || entities.isEmpty()) {
				throw new PricePortNotFoundException(messageProperty.getMessage(MessageCodeEnum.E098.name()));
			}
			
			return priceMapper.toDomains(entities);
		} catch(PricePortNotFoundException pe) {
			throw pe;
		} catch(Exception e) {
			LOG.error("findBrandProductPrices", e);
			throw new PricePortException(messageProperty.getMessage(MessageCodeEnum.E099.name()));
		}
	}

}
