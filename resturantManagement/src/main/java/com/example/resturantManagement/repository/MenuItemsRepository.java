package com.example.resturantManagement.repository;

import com.example.resturantManagement.model.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemsRepository extends JpaRepository<MenuItems, Long> {
}