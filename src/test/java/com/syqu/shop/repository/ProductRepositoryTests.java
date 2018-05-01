package com.syqu.shop.repository;

import com.syqu.shop.product.Product;
import com.syqu.shop.product.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    private Product createTestObject(){
        Product testObject = new Product();

        testObject.setName("testName");
        testObject.setDescription("testDescriptionTestDescription");
        testObject.setPrice(new BigDecimal(new Random().nextInt(1000)));
        testObject.setImageUrl("https://avatars1.githubusercontent.com/u/30699233?s=400&u=cf0bc2b388b5c72364aaaedf26a8aab63f97ffcc&v=4");

        return testObject;
    }

    @Test
    public void checkIfParamsAreTheSame(){
        Product testObject = createTestObject();
        entityManager.persistAndFlush(testObject);

        Product found = productRepository.findByName(testObject.getName());

        assertThat(found.getId()).isEqualTo(testObject.getId());
        assertThat(found.getName()).isEqualTo(testObject.getName());
        assertThat(found.getDescription()).isEqualTo(testObject.getDescription());
        assertThat(found.getPrice()).isEqualTo(testObject.getPrice());
        assertThat(found.getImageUrl()).isEqualTo(testObject.getImageUrl());
    }

    @Test
    public void whenFindByNameThenReturnProduct() {
        Product testObject = createTestObject();
        entityManager.persistAndFlush(testObject);

        Product found = productRepository.findByName(testObject.getName());
        assertThat(found.getName()).isEqualTo(testObject.getName());
    }

    @Test
    public void whenFindByIdThenReturnProduct(){
        Product testObject = createTestObject();
        entityManager.persistAndFlush(testObject);

        Product found = productRepository.findById(testObject.getId());
        assertThat(found.getId()).isEqualTo(testObject.getId());
    }

    @Test
    public void whenFindAllByOrderByIdAscThenReturnAllProducts(){
        Product testObject1 = createTestObject();
        Product testObject2 = createTestObject();
        Product testObject3 = createTestObject();
        entityManager.persistAndFlush(testObject1);
        entityManager.persistAndFlush(testObject2);
        entityManager.persistAndFlush(testObject3);

        List<Product> found = productRepository.findAllByOrderByIdAsc();
        assertThat(found.size()).isEqualTo(3);
        assertThat(found.get(0).getId()).isEqualTo(testObject1.getId());
        assertThat(found.get(1).getId()).isEqualTo(testObject2.getId());
        assertThat(found.get(2).getId()).isEqualTo(testObject3.getId());
    }

    @Test
    public void whenFindByIdAndNoProductReturnNull(){
        assertThat(productRepository.findById(new Random().nextLong())).isNull();
    }

    @Test
    public void whenFindByNameAndNoProductReturnNull(){
        assertThat(productRepository.findByName("random string")).isNull();
    }

    @Test
    public void whenFindAllByOrderByIdAscAndNoProductsReturnNull(){
        assertThat(productRepository.findAllByOrderByIdAsc()).isNullOrEmpty();
    }
}
