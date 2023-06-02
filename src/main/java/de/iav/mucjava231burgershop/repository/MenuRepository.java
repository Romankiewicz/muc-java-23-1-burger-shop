package de.iav.mucjava231burgershop.repository;

import de.iav.mucjava231burgershop.exception.MenuNotFoundException;
import de.iav.mucjava231burgershop.model.Menu;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

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
            if (singleMenuFromList.id().equals(idOfRequestedMenu)) {
                return singleMenuFromList;
            }
        }
        throw new MenuNotFoundException(idOfRequestedMenu);
    }

    public void addMenu(Menu menuToAdd){
        menus.add(menuToAdd);
    }

    public Menu changeMenu(String id, Menu menuToChange) {

        for (Menu singleMenuFromList : menus) {
            if (singleMenuFromList.id().equals(id)) {
                menus.remove(singleMenuFromList);
                Menu changedMenu = new Menu(id,
                        menuToChange.name(),
                        menuToChange.price(),
                        menuToChange.mainDish(),
                        menuToChange.sideDish(),
                        menuToChange.beverage());
                        menus.add(changedMenu);
            }
            return menuToChange;

        }
        throw new MenuNotFoundException(id);
    }

    public void deleteMenu(String idOfMenuToDelete){
        for (Menu menuToDelete : menus){
            if (menuToDelete.id().equals(idOfMenuToDelete)){
                menus.remove(menuToDelete);
            }
        }
    }

}
