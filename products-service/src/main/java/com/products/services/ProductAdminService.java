package com.products.services;

import java.util.List;

import com.products.dto.ProductDTO;

public interface ProductAdminService {
	
	public List<ProductDTO> adminGetAllProducts();
	public ProductDTO adminGetProduct(Long productId);
	public ProductDTO adminAddProduct(ProductDTO product);
	public ProductDTO adminUpdateProduct(ProductDTO product);
	public ProductDTO adminDeleteProduct(Long productId);

}
