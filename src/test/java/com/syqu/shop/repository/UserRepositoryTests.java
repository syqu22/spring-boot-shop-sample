package com.syqu.shop.repository;

import com.syqu.shop.creator.UserCreator;
import com.syqu.shop.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkIfUserRepositoryIsNotNull(){
        assertThat(userRepository).isNotNull();
    }

    @Test
    public void checkIfParamsAreTheSame(){
        User testObject = UserCreator.createTestUser();
        entityManager.persistAndFlush(testObject);

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
        assertThat(found.getCity()).isEqualTo(testObject.getCity());
        assertThat(found.getGender()).isEqualTo(testObject.getGender());
    }

    @Test
    public void whenFindByEmailThenReturnUser(){
        User testObject = UserCreator.createTestUser();

        entityManager.persistAndFlush(testObject);

        User found = userRepository.findByEmail(testObject.getEmail());
        assertThat(found.getEmail()).isEqualTo(testObject.getEmail());
    }

    @Test
    public void whenFindByIdThenReturnUser(){
        User testObject = UserCreator.createTestUser();

        entityManager.persistAndFlush(testObject);

        User found = userRepository.findById(testObject.getId());
        assertThat(found.getId()).isEqualTo(testObject.getId());
    }

    @Test
    public void whenFindByIdAndNoUserThenReturnNull() {
        assertThat(userRepository.findById(new Random().nextLong())).isNull();
    }

    @Test
    public void whenFindByUsernameAndNoUserThenReturnNull() {
        assertThat(userRepository.findByUsername("xxminecraftplayerxx")).isNull();
    }

    @Test
    public void whenFindByEmailAndNoUserThenReturnNull() {
        assertThat(userRepository.findByEmail("whatis@going.on")).isNull();
    }
}
