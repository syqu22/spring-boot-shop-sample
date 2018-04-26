package com.syqu.shop.controller;

import com.syqu.shop.product.Product;
import com.syqu.shop.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Product>products = getAllProducts();

        model.addAttribute("products",products);
        return "home";
    }

    @GetMapping("/index")
    public String home1(Model model){
        List<Product>products = getAllProducts();

        model.addAttribute("products",products);
        return "home";
    }

    @GetMapping("/home")
    public String home2(Model model){
        List<Product>products = getAllProducts();

        model.addAttribute("products",products);
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/help")
    public String help(){
        return "help";
    }

    private List<Product> getAllProducts(){
        return productService.findAllByOrderByIdAsc();
    }
}
