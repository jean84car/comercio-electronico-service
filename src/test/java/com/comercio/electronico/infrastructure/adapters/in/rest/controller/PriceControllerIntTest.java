package com.comercio.electronico.infrastructure.adapters.in.rest.controller;

import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PriceControllerIntTest {

	@Autowired
	private WebTestClient client;
	
	@Test
	@Order(1)
	void testPeticionUno() {
		client.get()
			.uri(uriBuilder -> uriBuilder.path("/api/v1/price")
					.queryParam("applicationDate", "2020-06-14 10:00:00")
					.queryParam("productoId", 35455)
					.queryParam("brandId", 1)
					.build())
			.exchange()
			.expectStatus().isOk()
			.expectBody().jsonPath("$.code").isEqualTo("I000")
			.jsonPath("$.priceList").value(is(1))
			.jsonPath("$.price").value(is(35.50));
	}
 
	@Test
	@Order(2)
	void testPeticionDos() {
		client.get()
			.uri(uriBuilder -> uriBuilder.path("/api/v1/price")
					.queryParam("applicationDate", "2020-06-14 16:00:00")
					.queryParam("productoId", 35455)
					.queryParam("brandId", 1)
					.build())
			.exchange()
			.expectStatus().isOk()
			.expectBody().jsonPath("$.code").isEqualTo("I000")
			.jsonPath("$.priceList").value(is(2))
			.jsonPath("$.price").value(is(25.45));
	}
	
	@Test
	@Order(3)
	void testPeticionTres() {
		client.get()
			.uri(uriBuilder -> uriBuilder.path("/api/v1/price")
					.queryParam("applicationDate", "2020-06-14 21:00:00")
					.queryParam("productoId", 35455)
					.queryParam("brandId", 1)
					.build())
			.exchange()
			.expectStatus().isOk()
			.expectBody().jsonPath("$.code").isEqualTo("I000")
			.jsonPath("$.priceList").value(is(1))
			.jsonPath("$.price").value(is(35.50));
	}
	
	@Test
	@Order(4)
	void testPeticionCuatro() {
		client.get()
			.uri(uriBuilder -> uriBuilder.path("/api/v1/price")
					.queryParam("applicationDate", "2020-06-15 10:00:00")
					.queryParam("productoId", 35455)
					.queryParam("brandId", 1)
					.build())
			.exchange()
			.expectStatus().isOk()
			.expectBody().jsonPath("$.code").isEqualTo("I000")
			.jsonPath("$.priceList").value(is(3))
			.jsonPath("$.price").value(is(30.50));
	}
	
	@Test
	@Order(5)
	void testPeticionCinco() {
		client.get()
			.uri(uriBuilder -> uriBuilder.path("/api/v1/price")
					.queryParam("applicationDate", "2020-06-16 21:00:00")
					.queryParam("productoId", 35455)
					.queryParam("brandId", 1)
					.build())
			.exchange()
			.expectStatus().isOk()
			.expectBody().jsonPath("$.code").isEqualTo("I000")
			.jsonPath("$.priceList").value(is(4))
			.jsonPath("$.price").value(is(38.95));
	}
	
}
