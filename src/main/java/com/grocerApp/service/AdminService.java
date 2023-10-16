package com.grocerApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grocerApp.model.GroceryItem;

	
@Service
	public interface AdminService {
	    GroceryItem addGroceryItem(GroceryItem item);
	    List<GroceryItem> viewAllGroceryItems();
	    void removeGroceryItem(Long itemId);
	    GroceryItem updateGroceryItem(GroceryItem item);
	    GroceryItem updateInventory(Long itemId, int quantity);
		GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem);
	}


