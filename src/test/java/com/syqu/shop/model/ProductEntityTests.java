package com.syqu.shop.model;

import com.syqu.shop.creator.ProductCreator;
import com.syqu.shop.domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ProductEntityTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createProductWhenNameIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        Product testObject = ProductCreator.createTestProduct();
        testObject.setName(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createProductWhenNameIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        Product testObject = ProductCreator.createTestProduct();
        testObject.setName("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createProductWhenDescriptionIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        Product testObject = ProductCreator.createTestProduct();
        testObject.setDescription(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createProductWhenDescriptionIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        Product testObject = ProductCreator.createTestProduct();
        testObject.setDescription("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createProductWhenDescriptionIsToLongShouldThrowException() {
        this.thrown.expect(PersistenceException.class);
        this.thrown.expectMessage("org.hibernate.exception.DataException: could not execute statement");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<101;i++){
            stringBuilder.append("testtest");
        }
        Product testObject = ProductCreator.createTestProduct();
        testObject.setDescription(stringBuilder.toString());

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createProductWhenImageUrlIsNotValidUrlShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("org.hibernate.validator.constraints.URL.message");

        Product testObject = ProductCreator.createTestProduct();
        testObject.setImageUrl("htt://test");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createProductWhenPriceIsNullThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        Product testObject = ProductCreator.createTestProduct();
        testObject.setPrice(null);

        entityManager.persistAndFlush(testObject);
    }
}
