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
    UserRepository userRepository;

    @Test
    public void whenFindByUserNameThenReturnUser() {
        User testObject = new User();
        testObject.setUsername("Bob");
        testObject.setPassword("longpassword123");
        testObject.setPasswordConfirm("longpassword123");
        testObject.setAge(new Random(100).nextInt());
        testObject.setEmail("randomemail@gmail.ru");
        testObject.setGender("Male");

        entityManager.persist(testObject);
        entityManager.flush();

        User found = userRepository.findByUsername(testObject.getUsername());
        assertThat(found.getUsername()).isEqualTo(testObject.getUsername());
    }

    @Test
    public void whenFindByEmailThenReturnUser(){
        User testObject = new User();
        testObject.setUsername("Bob");
        testObject.setPassword("longpassword123");
        testObject.setPasswordConfirm("longpassword123");
        testObject.setAge(new Random(100).nextInt());
        testObject.setEmail("randomemail@gmail.ru");
        testObject.setGender("Male");

        entityManager.persist(testObject);
        entityManager.flush();

        User found = userRepository.findByEmail(testObject.getEmail());
        assertThat(found.getEmail()).isEqualTo(testObject.getEmail());
    }
}
