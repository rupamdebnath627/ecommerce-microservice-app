package com.products.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.entities.Products;

public interface ProductsRepo extends JpaRepository<Products, Long> {

}
