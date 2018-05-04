package com.syqu.shop.controller;

import com.syqu.shop.cart.ShoppingCartService;
import com.syqu.shop.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public CartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/cart")
    public String cart(Model model){

        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") long id, User user){
        //shoppingCartService.addProduct(user.getId(),id);
        logger.info("Product with id: " + id + " added to user with id: " + user.getId() + " cart.");

        return "redirect:/home";
    }
}
