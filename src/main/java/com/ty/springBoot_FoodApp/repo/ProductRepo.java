package com.ty.springBoot_FoodApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springBoot_FoodApp.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	/*
	 * @Query("select p from Product p where p.menu=?1") public List<Product>
	 * findAllProduct(int mid);
	 */}
