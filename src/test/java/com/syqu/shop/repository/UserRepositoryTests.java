package com.syqu.shop.repository;

import com.syqu.shop.user.User;
import com.syqu.shop.user.UserRepository;
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
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private User createTestObject(){
        User testObject = new User();

        testObject.setUsername("Bob");
        testObject.setPassword("longpassword123");
        testObject.setPasswordConfirm("longpassword123");
        testObject.setAge(new Random(100).nextInt());
        testObject.setEmail("randomemail@gmail.ru");
        testObject.setGender("Male");
        testObject.setBalance(100);
        testObject.setCity("Warsaw");
        testObject.setCountry("Poland");

        return testObject;
    }

    @Test
    public void checkIfParamsAreTheSame(){
        User testObject = createTestObject();
        entityManager.persist(testObject);
        entityManager.flush();

        User found = userRepository.findByUsername(testObject.getUsername());

        assertThat(found.getId()).isEqualTo(testObject.getId());
        assertThat(found.getUsername()).isEqualTo(testObject.getUsername());
        assertThat(found.getPassword()).isEqualTo(testObject.getPassword());
        assertThat(found.getPasswordConfirm()).isEqualTo(found.getPassword());
        assertThat(found.getPasswordConfirm()).isEqualTo(testObject.getPasswordConfirm());
        assertThat(found.getFirstName()).isEqualTo(testObject.getFirstName());
        assertThat(found.getLastName()).isEqualTo(testObject.getLastName());
        assertThat(found.getEmail()).isEqualTo(testObject.getEmail());
        assertThat(found.getAge()).isEqualTo(testObject.getAge());
        assertThat(found.getBalance()).isEqualTo(testObject.getBalance());
        assertThat(found.getCountry()).isEqualTo(testObject.getCountry());
        assertThat(found.getCity()).isEqualTo(testObject.getCity());
        assertThat(found.getGender()).isEqualTo(testObject.getGender());
    }

    @Test
    public void whenFindByUserNameThenReturnUser() {
        User testObject = createTestObject();

        entityManager.persist(testObject);
        entityManager.flush();

        User found = userRepository.findByUsername(testObject.getUsername());
        assertThat(found.getUsername()).isEqualTo(testObject.getUsername());
    }

    @Test
    public void whenFindByEmailThenReturnUser(){
        User testObject = createTestObject();

        entityManager.persist(testObject);
        entityManager.flush();

        User found = userRepository.findByEmail(testObject.getEmail());
        assertThat(found.getEmail()).isEqualTo(testObject.getEmail());
    }

    @Test
    public void whenFindByIdThenReturnUser(){
        User testObject = createTestObject();

        entityManager.persist(testObject);
        entityManager.flush();

        User found = userRepository.findById(testObject.getId());
        assertThat(found.getId()).isEqualTo(testObject.getId());
    }
}