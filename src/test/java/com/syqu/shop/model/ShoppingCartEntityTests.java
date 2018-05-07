package com.syqu.shop.model;

import com.syqu.shop.cart.ShoppingCart;
import com.syqu.shop.creator.ProductCreator;
import com.syqu.shop.creator.UserCreator;
import com.syqu.shop.product.Product;
import com.syqu.shop.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShoppingCartEntityTests {

    @Autowired
    private TestEntityManager entityManager;

    private ShoppingCart createTestObject(){
        ShoppingCart testObject = new ShoppingCart();
        User testUser = UserCreator.createTestUser();
        Set<Product> testProducts = ProductCreator.createTestProducts();

        testObject.setUser(testUser);
        //testObject.setProducts(testProducts);

        return testObject;
    }

    @Test
    public void checkIfShoppingCartIsNotNull(){
        ShoppingCart testObject = createTestObject();
        assertThat(testObject).isNotNull();
    }

    //TODO CART TESTS

}
