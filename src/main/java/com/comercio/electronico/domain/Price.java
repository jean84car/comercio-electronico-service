package com.comercio.electronico.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class Price {

	private BigInteger id;
	
	private Integer brandId;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;

	private Integer priceList;

	private BigInteger productoId;
	
	private Integer priority;
	
	private BigDecimal price;
	
	private String curr;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
	
}
