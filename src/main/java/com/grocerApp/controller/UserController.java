package com.grocerApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.grocerApp.model.GroceryItem;
import com.grocerApp.model.Orders;
import com.grocerApp.request.PlaceOrderRequest;
import com.grocerApp.service.UserService;

public class UserController {
	  @Autowired
	    private UserService userService;

	    @GetMapping("/viewAvailableItems")
	    public ResponseEntity<List<GroceryItem>> viewAvailableItems() {
	        List<GroceryItem> availableItems = userService.viewAvailableItems();
	        return ResponseEntity.ok(availableItems);
	    }
	    
	    @PostMapping("/placeOrder")
	    public ResponseEntity<Orders> placeOrder(@RequestBody PlaceOrderRequest orderRequest) {
	        Orders order = userService.placeOrder(orderRequest);
	        return ResponseEntity.status(HttpStatus.CREATED).body(order);
	    }
}
