package com.grocerApp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.annotation.Generated;

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    @ManyToMany
    @JoinTable(
        name = "order_groceryitem",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "groceryitem_id")
    )
    private List<GroceryItem> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<GroceryItem> getItems() {
		return items;
	}

	public void setItems(List<GroceryItem> items) {
		this.items = items;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setItemIds(List<Long> collect) {
		// TODO Auto-generated method stub
		
	}
    
    
}
