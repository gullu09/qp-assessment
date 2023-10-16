package com.grocerApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.grocerApp.model.GroceryItem;
import com.grocerApp.model.Orders;
import com.grocerApp.repository.GroceryItemRepository;
import com.grocerApp.repository.OrderRepository;
import com.grocerApp.repository.UserRepository;
import com.grocerApp.request.PlaceOrderRequest;

import jakarta.persistence.EntityNotFoundException;

public class UserServiceImpl implements UserService {
	
	@Autowired
    private GroceryItemRepository groceryItemRepository;
	@Autowired
    private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;


	@Override
	public Orders placeOrder(Long userId, List<Long> itemIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroceryItem> viewAvailableItems() {
		// TODO Auto-generated method stub
		return (List<GroceryItem>) groceryItemRepository.findAll();
	}

	
    public Orders placeOrder(PlaceOrderRequest orderRequest) {
        // Fetch the user and items based on the provided IDs
        User user = userRepository.findById(orderRequest.getUserId())
            .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + orderRequest.getUserId()));
        List<GroceryItem> items = (List<GroceryItem>) groceryItemRepository.findAllById(orderRequest.getItemIds());

        // Create a new order
        Orders order = new Orders();
        order.setUserId(((GroceryItem) user).getId());
        order.setItemIds(items.stream().map(GroceryItem::getId).collect(Collectors.toList()));

        // Save the order to the database
        return orderRepository.save(order);
    }

}

