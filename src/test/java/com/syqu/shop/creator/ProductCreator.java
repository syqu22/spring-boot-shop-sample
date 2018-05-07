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

        Product testProduct1 = new Product();
        Product testProduct2 = new Product();
        Product testProduct3 = new Product();

        testProduct1.setName("testProd");
        testProduct1.setDescription("testDescriptionTestDescription");
        testProduct1.setPrice(new BigDecimal(new Random().nextInt(1000)));

        testProduct2.setName("testBob");
        testProduct2.setDescription("testDescriptionTestDescription");
        testProduct2.setPrice(new BigDecimal(new Random().nextInt(1000)));

        testProduct3.setName("testBob");
        testProduct3.setDescription("testDescriptionTestDescription");
        testProduct3.setPrice(new BigDecimal(new Random().nextInt(1000)));

        testProducts.add(testProduct1);
        testProducts.add(testProduct2);
        testProducts.add(testProduct3);

        return testProducts;
    }
}
