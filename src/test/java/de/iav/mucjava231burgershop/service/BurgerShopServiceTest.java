package de.iav.mucjava231burgershop.service;

import de.iav.mucjava231burgershop.model.Menu;
import de.iav.mucjava231burgershop.repository.MenuRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BurgerShopServiceTest {
    MenuRepository menuRepository = mock(MenuRepository.class);
    BurgerShopService burgerShopService = new BurgerShopService(menuRepository);

    @Test
    void getMenus_whenMenuListIsEmpty_thenReturnEmptyList(){

        List<Menu> expectedMenus = new ArrayList<>();
        when(menuRepository.menuList()).thenReturn(expectedMenus);

        List<Menu> actualMenus = burgerShopService.listMenus();

        assertEquals(expectedMenus, actualMenus);
        assertEquals(0, actualMenus.size());

    }

}