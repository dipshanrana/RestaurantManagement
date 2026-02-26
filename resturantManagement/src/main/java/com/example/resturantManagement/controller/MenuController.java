package com.example.resturantManagement.controller;

import com.example.resturantManagement.dto.MenuDto;
import com.example.resturantManagement.dto.MenuItem;
import com.example.resturantManagement.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/getmenu")
    public ResponseEntity<List<MenuDto>> getMenu(){
        return ResponseEntity.ok().body(menuService.getMenuItems());
    }

    @PostMapping("/saveItems")
    public ResponseEntity<?> saveItem(@RequestBody MenuItem menuItem){
        return ResponseEntity.ok().body(menuService.addItem(menuItem        ));
    }
}
