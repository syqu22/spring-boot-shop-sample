package com.syqu.shop.repository;

import com.syqu.shop.cart.ShoppingCart;
import com.syqu.shop.cart.ShoppingCartRepository;
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

@DataJpaTest
@RunWith(SpringRunner.class)
public class ShoppingCartRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    private User createTestUser(){
        User testUser = new User();

        testUser.setUsername("Marc");
        testUser.setPassword("longpassword123");
        testUser.setPasswordConfirm("longpassword123");
        testUser.setFirstName("Map");
        testUser.setLastName("Rox");
        testUser.setAge(new Random(100).nextInt());
        testUser.setEmail("randomemail@gmail.ru");
        testUser.setGender("Male");
        testUser.setBalance(new BigDecimal(100));
        testUser.setCity("Warsaw");

        return testUser;
    }

    private Set<Product> createTestProducts(){
        Set<Product> testProducts = new HashSet<>();
        Product testProduct1 = new Product();
        Product testProduct2 = new Product();

        testProduct1.setName("testProd");
        testProduct1.setDescription("testDescriptionTestDescription");
        testProduct1.setPrice(new BigDecimal(new Random().nextInt(1000)));

        testProduct2.setName("testBob");
        testProduct2.setDescription("testDescriptionTestDescription");
        testProduct2.setPrice(new BigDecimal(new Random().nextInt(1000)));

        testProducts.add(testProduct1);
        testProducts.add(testProduct2);

        return testProducts;
    }

    private ShoppingCart createTestObject(){
        ShoppingCart testObject = new ShoppingCart();
        Set<Product> testProducts = createTestProducts();
        User testUser = createTestUser();

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
