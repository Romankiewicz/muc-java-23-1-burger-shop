package de.iav.mucjava231burgershop.controller;

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
    void listMenus_whenMenuListIsEmpty_thenExpectsStatusOkAndReturnEmptyListAsJson() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/api/menus"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

}