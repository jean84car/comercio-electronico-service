package com.comercio.electronico.infrastructure.adapters.out.database.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.comercio.electronico.infrastructure.adapters.out.database.entity.PriceEntity;

public interface PriceRepository extends CrudRepository<PriceEntity, BigInteger> {

	@Query("select p from PriceEntity p where p.brandId = ?1 and p.productoId = ?2 and ?3 between p.startDate and p.endDate ")
	public List<PriceEntity> findByBrandAndProduct(Integer brandId, BigInteger productoId, LocalDateTime date);
	
}
