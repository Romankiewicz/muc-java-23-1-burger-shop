package de.iav.mucjava231burgershop.controller;

import de.iav.mucjava231burgershop.model.Menu;
import de.iav.mucjava231burgershop.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class BurgerShopControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private MenuRepository menuRepository;

    @Test
    @DirtiesContext
    void listMenus_whenMenuListIsEmpty_thenExpectsStatusOkAndReturnEmptyListAsJson() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    @DirtiesContext
    void listMenus_whenAtLeastOneMenuExists_thanExpectStatusOkAndReturnMenuListAsJson() throws Exception {

        Menu testMenu = new Menu("1",
                "Double Cheesburger Menu",
                12.99,
                "Double Cheesburger",
                "French Fries",
                "0,5L Softdrink");
        menuRepository.addMenu(testMenu);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                        {
                                        "id": "1",
                                        "price": "12.99",
                                        "mainDish": "Double Cheesburger",
                                        "sideDish": "French Fries",
                                        "beverage": "0,5L Softdrink"
                                        }
                                    """
                ));

    }

}