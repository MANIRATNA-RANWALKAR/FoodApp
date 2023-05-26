package com.ty.springBoot_FoodApp.exception;

public class ProductIdNotFound extends RuntimeException {

	private String message = "Id not Found";

	@Override
	public String getMessage() {

		return message;
	}

	public ProductIdNotFound(String message) {
		this.message = message;
	}

}
