package com.example.resturantManagement.controller;

import com.example.resturantManagement.dto.MenuDto;
import com.example.resturantManagement.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/getmenu")
    public ResponseEntity<List<MenuDto>> getMenu(){
        return ResponseEntity.ok().body(menuService.getMenu());

    }
}
