package com.syqu.shop.model;

import com.syqu.shop.user.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.Random;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserEntityTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private TestEntityManager entityManager;

    private User createTestObject() {
        User testObject = new User();

        testObject.setUsername("Mark");
        testObject.setPassword("longpassword123");
        testObject.setPasswordConfirm("longpassword123");
        testObject.setFirstName("Max");
        testObject.setLastName("Rox");
        testObject.setAge(new Random(100).nextInt());
        testObject.setEmail("randomemail@gmail.ru");
        testObject.setGender("Male");
        testObject.setBalance(new BigDecimal(100));
        testObject.setCity("Warsaw");

        return testObject;
    }

    @Test
    public void createUserWhenUsernameIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = createTestObject();
        testObject.setUsername(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenUsernameIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = createTestObject();
        testObject.setUsername("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenEmailIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = createTestObject();
        testObject.setEmail("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenEmailHaveInvalidFormatShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must be a well-formed email address");

        User testObject = createTestObject();
        testObject.setEmail("syqu.pl");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenEmailIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = createTestObject();
        testObject.setEmail(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenPasswordIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = createTestObject();
        testObject.setPassword(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenPasswordIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = createTestObject();
        testObject.setPassword("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenPasswordConfirmIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = createTestObject();
        testObject.setPasswordConfirm(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenPasswordConfirmIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = createTestObject();
        testObject.setPasswordConfirm("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenGenderIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = createTestObject();
        testObject.setGender(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenGenderIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = createTestObject();
        testObject.setGender("");

        entityManager.persistAndFlush(testObject);
    }
}
