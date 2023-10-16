package com.grocerApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.Employeeangularcrudapp.model.Employee;
import com.grocerApp.model.GroceryItem;
import com.grocerApp.repository.GroceryItemRepository;
import com.grocerApp.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private AdminService adminService;
	
	
   @GetMapping("/viewItems")
  public ResponseEntity<List<GroceryItem>> viewAllGroceryItems() {
       List<GroceryItem> groceryItems = adminService.viewAllGroceryItems();
       return ResponseEntity.ok(groceryItems);
    }
    
    
    @PostMapping("/addItem")
     public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem item) {
        GroceryItem newItem = adminService.addGroceryItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }
    
    @DeleteMapping("/removeItem/{itemId}")
    public ResponseEntity<Void> removeGroceryItem(@PathVariable Long itemId) {
        adminService.removeGroceryItem(itemId);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/updateItem/{itemId}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem updatedItem) {
        GroceryItem updated = adminService.updateGroceryItem(itemId, updatedItem);
        return ResponseEntity.ok(updated);
    }
    @PutMapping("/updateInventory/{itemId}")
    public ResponseEntity<GroceryItem> updateInventory(@PathVariable Long itemId, @RequestParam int quantity) {
        GroceryItem updatedItem = adminService.updateInventory(itemId, quantity);
        return ResponseEntity.ok(updatedItem);
    }
}
