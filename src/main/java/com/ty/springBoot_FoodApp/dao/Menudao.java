package com.ty.springBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.repo.MenuRepo;

@Repository
public class Menudao {

	@Autowired
	private MenuRepo repo;

	public Menu saveMenu(Menu menu) {
		return repo.save(menu);
	}

	public Menu updateMenu(Menu menu, int id) {
		Optional<Menu> menu2 = repo.findById(id);
		if (menu2.isPresent()) {
			menu.setMid(id);
			repo.save(menu);
			return menu2.get();
		} 
			return null;
		
	}

	public Menu deleteMenu(int mid) {
		Optional<Menu> menu = repo.findById(mid);
		if (menu.isPresent()) {
			repo.deleteById(mid);
			return menu.get();
		} 
			return null;
		
	}

	public Menu getMenuById(int mid) {
		Optional<Menu> menu = repo.findById(mid);
		if (menu.isPresent()) {
			return menu.get();
		} else {
			return null;
		}
	}

	public List<Menu> getAllMenu() {
		return repo.findAll();
	}

	public Menu getMenuByName(String mname) {
		Menu menu = repo.getMenuByMenuname(mname);
		if (menu != null) {
			return menu;
		} else {
			return null;
		}
	}
}
