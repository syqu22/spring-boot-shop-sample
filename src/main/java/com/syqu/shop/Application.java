package com.syqu.shop;

import com.syqu.shop.cart.ShoppingCartRepository;
import com.syqu.shop.product.ProductRepository;
import com.syqu.shop.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, ProductRepository.class, ShoppingCartRepository.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
