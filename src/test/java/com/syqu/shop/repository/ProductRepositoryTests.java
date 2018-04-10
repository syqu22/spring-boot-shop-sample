package com.syqu.shop.repository;

import com.syqu.shop.product.Product;
import com.syqu.shop.product.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void whenFindByNameThenReturnProduct() {
        Product testObject = new Product();
        testObject.setName("testName");
        testObject.setDescription("testDescriptionTestDescription");
        testObject.setPrice(new Random().nextDouble());

        entityManager.persist(testObject);
        entityManager.flush();

        Product found = productRepository.findByName(testObject.getName());
        assertThat(found.getName()).isEqualTo(testObject.getName());
    }

    @Test
    public void whenFindByIdThenReturnProduct(){
        Product testObject = new Product();
        testObject.setName("nameTest");
        testObject.setDescription("descriptionTestDescriptionTest");
        testObject.setPrice(new Random().nextDouble());

        entityManager.persist(testObject);
        entityManager.flush();

        Product found = productRepository.findById(testObject.getId());
        assertThat(found.getId()).isEqualTo(testObject.getId());
    }
}
