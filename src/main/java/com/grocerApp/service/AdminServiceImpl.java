package com.grocerApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grocerApp.model.GroceryItem;
import com.grocerApp.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
    private AdminRepository adminRepository;
	
	@Override
	public List<GroceryItem> viewAllGroceryItems() {
        return (List<GroceryItem>) adminRepository.findAll();
    }

	
	@Override
	public GroceryItem addGroceryItem(GroceryItem item) {
		// TODO Auto-generated method stub
		return adminRepository.save(item);
	}



	@Override
	 public void removeGroceryItem(Long itemId) {
        adminRepository.deleteById(itemId);
    }
	
	@Override
	public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem) {
        // Check if the item exists
        Optional<GroceryItem> existingItemOptional = adminRepository.findById(itemId);
        if (existingItemOptional.isPresent()) {
            GroceryItem existingItem = existingItemOptional.get();
            
            // Update the properties of the existing item with the values from updatedItem
            existingItem.setName(updatedItem.getName());
            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setInventory(updatedItem.getInventory());
            
            return adminRepository.save(existingItem);
        } else {
            
        	 return null;
        }
	}


	@Override
	 public GroceryItem updateInventory(Long itemId, int quantity) {
        // Check if the item exists
        Optional<GroceryItem> itemOptional = adminRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            GroceryItem item = itemOptional.get();

            // Update the inventory
            int updatedInventory = item.getInventory() + quantity;
            item.setInventory(updatedInventory);

            // Save the updated item
            return adminRepository.save(item);
        } else {
            
            return null;
        }
    }


	@Override
	public GroceryItem updateGroceryItem(GroceryItem item) {
		// TODO Auto-generated method stub
		return null;
	}

}
