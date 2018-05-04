package com.syqu.shop;

import com.syqu.shop.product.Product;
import com.syqu.shop.product.ProductService;
import com.syqu.shop.user.User;
import com.syqu.shop.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoadStartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public LoadStartupData(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Female");
        user.setEmail("user@example.com");

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void exampleProducts(){
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName("Example Name");
        product1.setImageUrl("https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg");
        product1.setDescription("Example Description");
        product1.setPrice(new BigDecimal(22));

        product2.setName("Example Name");
        product2.setImageUrl("https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg");
        product2.setDescription("Example Description");
        product2.setPrice(new BigDecimal(22));

        product3.setName("Example Name");
        product3.setImageUrl("https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg");
        product3.setDescription("Example Description");
        product3.setPrice(new BigDecimal(22));

        product4.setName("Example Name");
        product4.setImageUrl("https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg");
        product4.setDescription("Example Description");
        product4.setPrice(new BigDecimal(22));

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
    }
}
