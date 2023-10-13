package com.comercio.electronico.infrastructure.adapters.in.rest.controller.response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class PriceResponse extends BaseResponse {
	
	private Integer brandId;

	private Integer priceList;

	private BigInteger productoId;
	
	private BigDecimal price;
	
	private LocalDateTime applicationDate;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public BigInteger getProductoId() {
		return productoId;
	}

	public void setProductoId(BigInteger productoId) {
		this.productoId = productoId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDateTime applicationDate) {
		this.applicationDate = applicationDate;
	}
	
}
