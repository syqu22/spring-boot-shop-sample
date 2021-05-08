package com.syqu.shop.model;

import com.syqu.shop.creator.UserCreator;
import com.syqu.shop.domain.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class UserEntityTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createUserWhenUsernameIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = UserCreator.createTestUser();
        testObject.setUsername(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenUsernameIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = UserCreator.createTestUser();
        testObject.setUsername("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenEmailIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = UserCreator.createTestUser();
        testObject.setEmail("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenEmailHaveInvalidFormatShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must be a well-formed email address");

        User testObject = UserCreator.createTestUser();
        testObject.setEmail("syqu.pl");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenEmailIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = UserCreator.createTestUser();
        testObject.setEmail(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenPasswordIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = UserCreator.createTestUser();
        testObject.setPassword(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenPasswordIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = UserCreator.createTestUser();
        testObject.setPassword("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenPasswordConfirmIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = UserCreator.createTestUser();
        testObject.setPasswordConfirm(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenPasswordConfirmIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = UserCreator.createTestUser();
        testObject.setPasswordConfirm("");

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenGenderIsNullShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be null");

        User testObject = UserCreator.createTestUser();
        testObject.setGender(null);

        entityManager.persistAndFlush(testObject);
    }

    @Test
    public void createUserWhenGenderIsEmptyShouldThrowException() {
        this.thrown.expect(ConstraintViolationException.class);
        this.thrown.expectMessage("must not be empty");

        User testObject = UserCreator.createTestUser();
        testObject.setGender("");

        entityManager.persistAndFlush(testObject);
    }
}
