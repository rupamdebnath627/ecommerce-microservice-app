package com.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.products.dto.ProductDTO;
import com.products.services.ProductAdminServiceImpl;


@RestController
@RequestMapping("/product")
public class AdminControllers {
	
	@Autowired
	private ProductAdminServiceImpl productServiceImpl;
	
	@GetMapping(value="/admin-get-all-products", produces = "application/json")
	public ResponseEntity<List<ProductDTO>> adminGetAllProducts() {
		List<ProductDTO> products = productServiceImpl.adminGetAllProducts();
		return new ResponseEntity<>(products,HttpStatus.OK); 
	}
	
	@GetMapping(value="/admin-get-product", produces = "application/json")
	public ResponseEntity<ProductDTO> adminGetProduct(@RequestParam Long productId) {
		ProductDTO product = productServiceImpl.adminGetProduct(productId);
		return new ResponseEntity<>(product,HttpStatus.OK); 
	}
	
	@PostMapping(value = "/admin-add-product", produces = "application/json")
	public ResponseEntity<ProductDTO> adminAddProduct(@RequestBody ProductDTO product){
		return new ResponseEntity<>(productServiceImpl.adminAddProduct(product),HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "/admin-update-product", produces = "application/json")
	public ResponseEntity<ProductDTO> adminUpdateProduct(@RequestBody ProductDTO product){
		return new ResponseEntity<>(productServiceImpl.adminUpdateProduct(product),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping(value = "/admin-delete-product", produces = "application/json")
	public ResponseEntity<ProductDTO> adminUpdateProduct(@RequestParam Long productId){
		return new ResponseEntity<>(productServiceImpl.adminDeleteProduct(productId),HttpStatus.ACCEPTED);
		
	}

}
