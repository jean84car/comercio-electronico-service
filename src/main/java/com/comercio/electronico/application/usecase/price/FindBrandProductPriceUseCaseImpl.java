package com.comercio.electronico.application.usecase.price;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.comercio.electronico.application.common.Utils;
import com.comercio.electronico.application.configuration.MessageProperty;
import com.comercio.electronico.domain.Price;
import com.comercio.electronico.domain.enums.MessageCodeEnum;
import com.comercio.electronico.domain.enums.MessageTypeEnum;
import com.comercio.electronico.infrastructure.adapters.out.database.PriceDatabaseAdapter;
import com.comercio.electronico.infrastructure.ports.in.usecase.price.FindBrandProductPriceUseCase;
import com.comercio.electronico.infrastructure.ports.in.usecase.price.PriceNoSuchElementException;

@Service
public class FindBrandProductPriceUseCaseImpl implements FindBrandProductPriceUseCase {
	
	private static final Logger LOG = LoggerFactory.getLogger(FindBrandProductPriceUseCaseImpl.class);
	
	private PriceDatabaseAdapter priceDatabaseAdapter;
	private Utils utils;
	private MessageProperty messageProperty;
	
	public FindBrandProductPriceUseCaseImpl(PriceDatabaseAdapter priceDatabaseAdapter, Utils utils, MessageProperty messageProperty) {
		this.priceDatabaseAdapter = priceDatabaseAdapter;
		this.utils = utils;
		this.messageProperty = messageProperty;
	}

	@Override
	public Price findBrandProductPrice(LocalDateTime date, BigInteger productoId, Integer brandId) {
		LOG.info(utils.getLog(String.format("date: %s, productoId: %d, brandId : %d", utils.getTimeFormat(date), productoId, brandId), MessageTypeEnum.INFO.name()));
		List<Price> prices = priceDatabaseAdapter.findBrandProductPrice(date, productoId, brandId);
		Optional<Price> price = prices.stream().max(Comparator.comparing(Price::getPriority));
		if(!price.isPresent()) {
			throw new PriceNoSuchElementException(messageProperty.getMessage(MessageCodeEnum.E098.name()));
		}
		return price.get();	
	}

}
