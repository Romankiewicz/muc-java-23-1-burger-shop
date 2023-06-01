package de.iav.mucjava231burgershop.repository;

import de.iav.mucjava231burgershop.exception.MenuNotFoundException;
import de.iav.mucjava231burgershop.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MenuRepository {

    private final List<Menu> menus;

    public MenuRepository(){
        menus = new ArrayList<>();
    }
    public MenuRepository(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> menuList(){
        return menus;
    }

    public Menu getMenuById(String idOfRequestedMenu){
        for (Menu singleMenuFromList : menus){
            if(singleMenuFromList.id().equals(idOfRequestedMenu)) {
                return singleMenuFromList;
            }
        }
        throw new MenuNotFoundException(idOfRequestedMenu);
    }

}
