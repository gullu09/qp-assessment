package com.grocerApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.grocerApp.model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long> {
}