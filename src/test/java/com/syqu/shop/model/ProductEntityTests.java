package com.syqu.shop.model;

import com.syqu.shop.product.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.Random;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductEntityTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private TestEntityManager entityManager;

    private Product createTestObject() {
        Product testObject = new Product();

        testObject.setName("testBob");
        testObject.setDescription("testDescriptionTestDescription");
        testObject.setPrice(new BigDecimal(new Random().nextInt(1000)));
        testObject.setImageUrl("https://avatars1.githubusercontent.com/u/30699233?s=400&u=cf0bc2b388b5c72364aaaedf26a8aab63f97ffcc&v=4");

        return testObject;
    }

    @Test
    public void createProductWhenNameIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        Product testObject = createTestObject();
        testObject.setName(null);

        entityManager.persist(testObject);
        entityManager.flush();
    }

    @Test
    public void createProductWhenNameIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        Product testObject = createTestObject();
        testObject.setName("");

        entityManager.persist(testObject);
        entityManager.flush();
    }

    @Test
    public void createProductWhenDescriptionIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        Product testObject = createTestObject();
        testObject.setDescription(null);

        entityManager.persist(testObject);
        entityManager.flush();
    }

    @Test
    public void createProductWhenDescriptionIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        Product testObject = createTestObject();
        testObject.setDescription("");

        entityManager.persist(testObject);
        entityManager.flush();
    }

    @Test
    public void createProductWhenDescriptionIsToLongShouldThrowException() {
        this.thrown.expect(PersistenceException.class);
        this.thrown.expectMessage("org.hibernate.exception.DataException: could not execute statement");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<101;i++){
            stringBuilder.append("omega");
        }
        Product testObject = createTestObject();
        testObject.setDescription(stringBuilder.toString());

        entityManager.persist(testObject);
        entityManager.flush();
    }

    @Test
    public void createProductWhenImageUrlIsNotValidUrlShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("org.hibernate.validator.constraints.URL.message");

        Product testObject = createTestObject();
        testObject.setImageUrl("htt://okxd");

        entityManager.persist(testObject);
        entityManager.flush();
    }
}
