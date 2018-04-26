package com.syqu.shop.controller;


import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HomeControllerMvcTests {
    //TODO fix later
    /*private MockMvc mockMvc;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController())
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
    @Test

    public void homeControllerStatus5() throws Exception{
        this.mockMvc.perform(get("/help")).andExpect(status().isOk())
                .andExpect(view().name("help")).andDo(print());
    }
    */
}
