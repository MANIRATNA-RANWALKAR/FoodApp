package com.ty.springBoot_FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/saveproduct")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/updateproduct")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,
			@RequestParam int id) {
		return service.updateProduct(id, product);
	}

	@DeleteMapping("/deleteproduct")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int id) {
		return service.deleteProduct(id);
	}

	@GetMapping("/getproductbyid")
	public ResponseEntity<ResponseStructure<Product>> getproductById(@RequestParam int id) {
		return service.getProductById(id);
	}

	/*
	 * @GetMapping("/getallproduct") public
	 * ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(@RequestParam
	 * int mid) { return service.getAllProduct(mid); }
	 */
}
