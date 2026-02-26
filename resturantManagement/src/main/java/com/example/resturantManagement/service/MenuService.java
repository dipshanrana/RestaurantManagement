package com.example.resturantManagement.service;

import com.example.resturantManagement.dto.MenuDto;
import com.example.resturantManagement.dto.MenuItem;
import com.example.resturantManagement.model.MenuItems;
import com.example.resturantManagement.repository.MenuItemsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuItemsRepository menuItemsRepository;
    private final ModelMapper modelMapper;


    public List<MenuDto> getMenuItems() {
        List<MenuItems>  menuItems =  menuItemsRepository.findAll();
        return menuItems.stream().map(a-> modelMapper.map(a,MenuDto.class)).toList();
    }

    public void addItem(MenuItem menuItem) {
        MenuItems menuItems = MenuItems.builder().name(menuItem.getName()).price(menuItem.getPrice()).build();
        menuItemsRepository.save(menuItems);
    }
}
