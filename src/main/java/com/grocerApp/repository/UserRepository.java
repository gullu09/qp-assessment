package com.grocerApp.repository;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import com.grocerApp.model.GroceryItem;

public interface UserRepository extends CrudRepository<User, Long> {

}