package com.grocerApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.grocerApp.model.GroceryItem;
import com.grocerApp.model.Orders;

public interface AdminRepository extends CrudRepository<GroceryItem, Long>{
	
}
