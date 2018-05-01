package com.syqu.shop.model;

import com.syqu.shop.cart.ShoppingCart;
import com.syqu.shop.product.Product;
import com.syqu.shop.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShoppingCartEntityTests {

    @Autowired
    private TestEntityManager entityManager;

    private User createTestUser(){
        User testUser = new User();

        testUser.setUsername("Mark");
        testUser.setPassword("longpassword123");
        testUser.setPasswordConfirm("longpassword123");
        testUser.setFirstName("Map");
        testUser.setLastName("Rox");
        testUser.setAge(new Random(100).nextInt());
        testUser.setEmail("randomemail@gmail.ru");
        testUser.setGender("Male");
        testUser.setBalance(100);
        testUser.setCity("Warsaw");
        testUser.setCountry("Poland");

        return testUser;
    }

    private Set<Product> createTestProducts(){
        Set<Product> testProducts = new HashSet<>();
        Product testProduct1 = new Product();
        Product testProduct2 = new Product();
        Product testProduct3 = new Product();

        testProduct1.setName("testBob");
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

    private ShoppingCart createTestObject(){
        ShoppingCart testObject = new ShoppingCart();
        User testUser = createTestUser();
        Set<Product> testProducts = createTestProducts();

        testObject.setUser(testUser);
        testObject.setProducts(testProducts);

        return testObject;
    }

    @Test
    public void checkIfShoppingCartIsNotNull(){
        ShoppingCart testObject = createTestObject();
        assertThat(testObject).isNotNull();
    }

    //TODO CART TESTS

}
