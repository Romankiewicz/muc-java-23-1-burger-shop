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

    @Test

    void getMenus_whenAtLeastOneMenuExists_thenReturnMenuList(){

       Menu ecpectedMenu = new Menu("1",
               "Double Cheesburger Menu",
               12.99,
               "Double Cheesburger",
               "French Fries",
               "0,5L Softdrink");

       List<Menu> expectedMenus = new ArrayList<>();
       expectedMenus.add(ecpectedMenu);

       when(menuRepository.menuList()).thenReturn(expectedMenus);

       List<Menu> actualMenus = burgerShopService.listMenus();

       assertEquals(expectedMenus, actualMenus);
       verify(menuRepository).menuList();

    }

    @Test
    void getMenuById_whenRequestedIdExists_thenReturnMenuWithRequestedId(){

        Menu expectedMenu = new Menu("1",
                "Double Cheesburger Menu",
                12.99,
                "Double Cheesburger",
                "French Fries",
                "0,5L Softdrink");



        when(menuRepository.getMenuById(expectedMenu.id())).thenReturn(expectedMenu);

        Menu actualMenu = burgerShopService.getMenuById(expectedMenu.id());

        assertEquals(expectedMenu, actualMenu);
        verify(menuRepository).getMenuById(any());
    }

    @Test
    void addMenu_whenMenuWasPlacedSuccessfully_thenVerifyMethodIsCalled() {

        Menu expectedMenu = new Menu("2",
                "Double Cheesburger Menu",
                12.99,
                "Double Cheesburger",
                "French Fries",
                "0,5L Softdrink");

        burgerShopService.addMenu(expectedMenu);
        verify(menuRepository).addMenu(any());
    }

    @Test
    void changeMenu_whenRequestedIdExists_thenReturnChangedMenu(){

        Menu expectedMenu = new Menu("1",
                "Double Cheesburger Menu",
                12.99,
                "Double Cheesburger",
                "French Fries",
                "0,5L Softdrink");

        Menu changedMenu = new Menu("2",
                "Cheesburger Menu",
                9.99,
                "Cheesburger",
                "Sweetpotato Fries",
                "0,5L Softdrink");

        when(menuRepository.changeMenu(expectedMenu.id(),changedMenu)).thenReturn(changedMenu);

        Menu actualMenu = burgerShopService.changeMenu(expectedMenu.id(), changedMenu);

        assertEquals(changedMenu, actualMenu);
    }

    @Test
    void deleteMenu_whenMenuWasDeletedSuccessfully_thenVerifyMethodIsCalled(){

        Menu expectedMenu = new Menu("2",
                "Double Cheesburger Menu",
                12.99,
                "Double Cheesburger",
                "French Fries",
                "0,5L Softdrink");

        burgerShopService.deleteMenu(expectedMenu.id());
        verify(menuRepository).deleteMenu(any());
    }

}