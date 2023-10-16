package com.grocerApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.grocerApp.model.GroceryItem;
	public interface GroceryItemRepository extends CrudRepository<GroceryItem, Long> {
	}
