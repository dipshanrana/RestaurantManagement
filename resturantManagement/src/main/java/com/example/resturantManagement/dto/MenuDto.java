package com.example.resturantManagement.dto;

import com.example.resturantManagement.model.MenuItems;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MenuDto {
    private List<MenuItems> menuItems;
}
