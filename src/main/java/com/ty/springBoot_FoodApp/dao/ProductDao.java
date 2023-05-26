package com.ty.springBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.repo.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepo repo;

	@Autowired
	private Menudao menudao;

	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	public Product updateProduct(Product product, int pid) {
		Optional<Product> product2 = repo.findById(pid);
		if (product2 != null) {
			product.setPid(pid);
			repo.save(product);
			return product2.get();
		} else {
			return null;
		}
	}

	public Product deleteproduct(int id) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent()) {
			repo.deleteById(id);
			return product.get();
		} else {
			return null;
		}
	}

	public Product getProductById(int id) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;

	}

	/*
	 * public List<Product> findallproducts(int mid) { List<Product> products =
	 * repo.findAll(); if (products != null) { return products; } else { return
	 * null; } }
	 */
}
