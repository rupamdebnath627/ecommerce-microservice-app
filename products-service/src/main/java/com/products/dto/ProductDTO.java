package com.products.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private Long productId;
	
	private String productType;
	
	private Integer quantity; 
	
	private boolean productActiveState;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate productAddDate;
	
	private String countryOfOrigin;
}
