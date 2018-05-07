package com.syqu.shop.repository;

import com.syqu.shop.cart.ShoppingCart;
import com.syqu.shop.cart.ShoppingCartRepository;
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

@DataJpaTest
@RunWith(SpringRunner.class)
public class ShoppingCartRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    private ShoppingCart createTestObject(){
        ShoppingCart testObject = new ShoppingCart();
        Set<Product> testProducts = ProductCreator.createTestProducts();
        User testUser = UserCreator.createTestUser();

        testObject.setUser(testUser);
        testObject.setProducts(testProducts);

        return testObject;
    }

    @Test
    public void checkIfShoppingCartRepositoryIsNotNull(){
        assertThat(shoppingCartRepository).isNotNull();
    }

    @Test
    public void checkIfParamsAreTheSame(){
        ShoppingCart testObject = createTestObject();
        entityManager.persistAndFlush(testObject);

        ShoppingCart found = shoppingCartRepository.findById(testObject.getId());

        assertThat(found.getId()).isEqualTo(testObject.getId());
        assertThat(found.getUser()).isEqualTo(testObject.getUser());
        assertThat(found.getProducts()).isEqualTo(testObject.getProducts());
    }

    @Test
    public void whenFindByIdThenReturnShoppingCart(){
        ShoppingCart testObject = createTestObject();
        entityManager.persistAndFlush(testObject);

        ShoppingCart found = shoppingCartRepository.findById(testObject.getId());
        assertThat(found.getId()).isEqualTo(testObject.getId());
    }
}
