package com.ty.springBoot_FoodApp.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.ProductDao;
import com.ty.springBoot_FoodApp.dto.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productdao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(productdao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(int id, Product product) {
		Product product2 = productdao.updateProduct(product, id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(productdao.saveProduct(product));
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);

		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {
		Product product = productdao.deleteproduct(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Product product = productdao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		}
		return null;

	}

	/*
	 * public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(int mid) { List<Product> product = productdao.findallproducts(mid);
	 * ResponseStructure<List<Product>> responseStructure = new
	 * ResponseStructure<>(); if (product != null) {
	 * responseStructure.setStatus(HttpStatus.OK.value());
	 * responseStructure.setMessage("Found"); responseStructure.setData(product);
	 * return new
	 * ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,
	 * HttpStatus.OK); } else { throw new NoSuchElementException(); }
	 * 
	 * }
	 */
}
