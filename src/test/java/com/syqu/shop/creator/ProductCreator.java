package com.syqu.shop.creator;

import com.syqu.shop.product.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ProductCreator {

    public static Product createTestProduct(){
        Product testProduct = new Product();

        testProduct.setName("Test");
        testProduct.setDescription("testDescriptionTestDescription");
        testProduct.setPrice(new BigDecimal(new Random().nextInt(1000)));
        testProduct.setImageUrl("https://avatars1.githubusercontent.com/u/30699233?s=400&u=cf0bc2b388b5c72364aaaedf26a8aab63f97ffcc&v=4");

        return testProduct;
    }

    public static Set<Product> createTestProducts(){
        Set<Product> testProducts = new HashSet<>();

        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());

        return testProducts;
    }
}
