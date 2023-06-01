package de.iav.mucjava231burgershop.service;

import de.iav.mucjava231burgershop.model.Menu;
import de.iav.mucjava231burgershop.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurgerShopService {

    private final MenuRepository menuRepository;

    public BurgerShopService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> listMenus() {
        return menuRepository.menuList();
    }

    public Menu getMenuById(String id) {
        return menuRepository.getMenuById(id);
    }

    public void addMenu(Menu menuToAdd) {
        menuRepository.addMenu(menuToAdd);
    }


    public Menu changeMenu(String idOfMenuToChange, Menu menuToChange) {
        return menuRepository.changeMenu(idOfMenuToChange, menuToChange);
    }
}
