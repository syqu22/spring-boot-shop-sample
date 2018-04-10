package com.syqu.shop.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
public class ContactControllerMvcTests {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new ContactController())
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void helpControllerStatus() throws Exception{
        this.mockMvc.perform(get("/help")).andExpect(status().isOk())
                .andExpect(view().name("help")).andDo(print());
    }

    @Test
    public void adminControllerStatus() throws Exception{
        this.mockMvc.perform(get("/about")).andExpect(status().isOk())
                .andExpect(view().name("about")).andDo(print());
    }
}
