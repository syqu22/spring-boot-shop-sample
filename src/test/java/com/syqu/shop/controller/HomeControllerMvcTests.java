package com.syqu.shop.controller;


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
public class HomeControllerMvcTests {
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController(productService))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void homeControllerStatus() throws Exception{
        this.mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(view().name("home")).andDo(print());
    }

    @Test
    public void homeControllerStatus2() throws Exception{
        this.mockMvc.perform(get("/index")).andExpect(status().isOk())
                .andExpect(view().name("home")).andDo(print());
    }
    @Test

    public void homeControllerStatus3() throws Exception{
        this.mockMvc.perform(get("/home")).andExpect(status().isOk())
                .andExpect(view().name("home")).andDo(print());
    }
    @Test

    public void homeControllerStatus4() throws Exception{
        this.mockMvc.perform(get("/about")).andExpect(status().isOk())
                .andExpect(view().name("about")).andDo(print());
    }
}
