package com.syqu.shop.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    /*private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);

        return "product";
    }
    */
}
