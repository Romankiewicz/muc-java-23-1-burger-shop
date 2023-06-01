package de.iav.mucjava231burgershop.controller;

import de.iav.mucjava231burgershop.model.Menu;
import de.iav.mucjava231burgershop.service.BurgerShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class BurgerShopController {

    private final BurgerShopService burgerShopService;

    public BurgerShopController(BurgerShopService burgerShopService) {
        this.burgerShopService = burgerShopService;
    }

    @GetMapping
    public List<Menu> listMenus(){
        return burgerShopService.listMenus();
    }

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable String id){
        return burgerShopService.getMenuById(id);
    }

    @PostMapping
    public void addMenu(@RequestBody Menu menuToAdd){
        burgerShopService.addMenu(menuToAdd);
    }

    @PutMapping("/{id}")
    public Menu changeMenu(@PathVariable String idOfMenuToChange, @RequestBody Menu menuToChange){
        return burgerShopService.changeMenu(idOfMenuToChange, menuToChange);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable String idOfMenuToDelete){
        burgerShopService.deleteMenu(idOfMenuToDelete);
    }
}
