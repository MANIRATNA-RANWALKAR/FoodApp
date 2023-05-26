package com.ty.springBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ty.springBoot_FoodApp.dto.Items;

public interface ItemRepo extends JpaRepository<Items, Integer>{

	@Query("Select i from Items i where i.item_name=?1")
	public Items getItemsByName(String item_name);
}
