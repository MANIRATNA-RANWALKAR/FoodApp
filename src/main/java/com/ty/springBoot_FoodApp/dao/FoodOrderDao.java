package com.ty.springBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepo repo;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return repo.save(foodOrder);
	}

	public FoodOrder updateFoodOrder(FoodOrder foodOrder, int fid) {
		Optional<FoodOrder> foodOrder2 = repo.findById(fid);
		if (foodOrder2.isPresent()) {
			foodOrder.setFid(fid);
			repo.save(foodOrder);
			return foodOrder2.get();
		} else {
			return null;
		}
	}

	public FoodOrder getFoodOrder(int id) {
		Optional<FoodOrder> foodOrder = repo.findById(id);
		if (foodOrder.isPresent()) {
			return foodOrder.get();
		}
		return null;
	}

	public FoodOrder deleteFoodOrder(int fid) {
		Optional<FoodOrder> foodOrder = repo.findById(fid);
		if (foodOrder.isPresent()) {
			repo.deleteById(fid);
			return foodOrder.get();
		} else {
			return null;
		}
	}

	public FoodOrder getFoodOrderById(int fid) {
		Optional<FoodOrder> foodOrder = repo.findById(fid);
		if (foodOrder.isEmpty()) {
			return null;
		} else {
			return foodOrder.get();
		}
	}

	public List<FoodOrder> getAllFoodOrder() {
		return repo.findAll();
	}

	public FoodOrder getFoodOrderByName(String fname) {
		FoodOrder foodOrder = repo.getFoodOrderByName(fname);
		if (foodOrder != null) {
			return foodOrder;
		} else {
			return null;
		}
	}

}
