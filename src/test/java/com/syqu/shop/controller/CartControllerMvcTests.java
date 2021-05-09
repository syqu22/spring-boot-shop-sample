package com.syqu.shop.controller;

import com.syqu.shop.service.ShoppingCartService;
import com.syqu.shop.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartControllerMvcTests {
    private MockMvc mockMvc;

    @MockBean
    ShoppingCartService shoppingCartService;

    @MockBean
    ProductService productService;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new CartController(shoppingCartService, productService))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void cartControllerStatus() throws Exception{
        this.mockMvc.perform(get("/cart")).andExpect(status().isOk())
                .andExpect(view().name("cart")).andDo(print());
    }
}
