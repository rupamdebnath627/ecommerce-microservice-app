package com.products.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.products.dto.ProductDTO;
import com.products.entities.Products;
import com.products.repo.ProductsRepo;

@Service
public class ProductAdminServiceImpl implements ProductAdminService {

	@Autowired
	private ProductsRepo productsRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	@Transactional
	public List<ProductDTO> adminGetAllProducts() {
		return productsRepo.findAll().stream().map(product -> mapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public ProductDTO adminGetProduct(Long productId) {
		if(productsRepo.existsById(productId)) {
			Products product = productsRepo.findById(productId).orElse(null);
			return mapper.map(product, ProductDTO.class);
		}
		return null;
	}

	@Override
	@Transactional
	public ProductDTO adminAddProduct(ProductDTO product) {
		return mapper.map(productsRepo.save(mapper.map(product, Products.class)), ProductDTO.class);
	}

	@Override
	@Transactional
	public ProductDTO adminUpdateProduct(ProductDTO product) {
		if(productsRepo.existsById(product.getProductId())) {
			productsRepo.save(mapper.map(product, Products.class));
			return product;
		}
		return null;
	}

	@Override
	@Transactional
	public ProductDTO adminDeleteProduct(Long productId) {
		if(productsRepo.existsById(productId)) {
			ProductDTO product = mapper.map(productsRepo.findById(productId).orElse(null),ProductDTO.class);
			productsRepo.deleteById(productId);
			return product;
		}
		return null;
	}

}
