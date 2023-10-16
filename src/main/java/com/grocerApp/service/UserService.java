package com.grocerApp.service;

import java.util.List;
import com.grocerApp.model.GroceryItem;
import com.grocerApp.model.Orders;
import com.grocerApp.request.PlaceOrderRequest;

	public interface UserService {
	    List<GroceryItem> viewAvailableItems();
	    Orders placeOrder(Long userId, List<Long> itemIds);
		Orders placeOrder(PlaceOrderRequest orderRequest);
	}


