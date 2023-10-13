package com.comercio.electronico.infrastructure.ports.in.rest;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comercio.electronico.infrastructure.adapters.in.rest.controller.response.BaseResponse;
import com.comercio.electronico.infrastructure.adapters.in.rest.controller.response.PriceResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface PriceController {

	@Operation(summary = "Find price of a brand's product", description = "Find price of a brand's product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
            	content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PriceResponse.class)) } ),
            @ApiResponse(responseCode = "400", description = "invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "product price not found", 
            	content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "internal system error", 
            		content = { @Content(mediaType = "application/json", schema = @Schema(implementation = BaseResponse.class)) })})
    @GetMapping
	public ResponseEntity<BaseResponse> findBrandProductPrice(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate, @RequestParam BigInteger productoId, 
			@RequestParam Integer brandId);
	
}
