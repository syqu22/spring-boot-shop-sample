package com.syqu.shop.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllersTests {

    @Autowired
    HomeController homeController;
    @Autowired
    AdminController adminController;
    @Autowired
    LoginController loginController;
    @Autowired
    RegisterController registerController;
    @Autowired
    UserController userController;
    @Autowired
    ProductController productController;

    @Test
    public void checkIfHomeControllerNotNull() {
        assertThat(homeController).isNotNull();
    }

    @Test
    public void checkIfUserControllerNotNull() {
        assertThat(userController).isNotNull();
    }

    @Test
    public void checkIfAdminControllerNotNull() {
        assertThat(adminController).isNotNull();
    }

    @Test
    public void checkIfLoginControllerNotNull() {
        assertThat(loginController).isNotNull();
    }

    @Test
    public void checkIfRegisterControllerNotNull() {
        assertThat(registerController).isNotNull();
    }

    @Test
    public void checkIfProductControllerNotNull() {
        assertThat(productController).isNotNull();
    }
}
