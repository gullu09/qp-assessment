package com.grocerApp.request;

import java.util.List;

public class PlaceOrderRequest {
    private Long userId;
    private List<Long> itemIds;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Long> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
	}
    
    

    
}
