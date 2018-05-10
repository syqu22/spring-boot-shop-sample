package com.syqu.shop.service;

import com.syqu.shop.Application;
import com.syqu.shop.creator.UserCreator;
import com.syqu.shop.user.User;
import com.syqu.shop.user.UserRepository;
import com.syqu.shop.user.UserService;
import com.syqu.shop.user.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTests {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Test
    public void checkIfUserServiceIsNotNull(){
        userService.save(UserCreator.createTestUser());
        assertThat(UserService.class).isNotNull();
        assertThat(UserServiceImpl.class).isNotNull();
    }

    @Test
    public void whenFindByIdThenReturnsUser() {
        User user = userService.findById(7);

        assertThat(user.getId()).isEqualTo(7);
    }

    @Test
    public void whenFindByUsernameThenReturnsUser() {
        User user = userService.findByUsername("Test");

        assertThat(user.getUsername()).isEqualTo("Test");
    }

    @Test
    public void whenFindByEmailThenReturnsUser() {
        User user = userService.findByEmail("randomemail@gmail.test");

        assertThat(user.getEmail()).isEqualTo("randomemail@gmail.test");
    }

    @Test
    public void checkIfSaveUserIsNotNull(){
        User user = userService.findByUsername("Test");

        assertThat(userService.findById(user.getId())).isNotNull();
        assertThat(userService.findByUsername(user.getUsername())).isNotNull();
        assertThat(userService.findByEmail(user.getEmail())).isNotNull();
    }

    @Test
    public void checkIfSavedUserHaveTheSameParameters(){
        User user = userService.findByUsername("Test");

        assertThat(user.getId()).isEqualTo(7);
        assertThat(user.getUsername()).isEqualTo("Test");
        assertThat(user.getEmail()).isEqualTo("randomemail@gmail.test");
        assertThat(user.getFirstName()).isEqualTo("Test");
        assertThat(user.getLastName()).isEqualTo("Test");
        assertThat(user.getGender()).isEqualTo("Male");
        assertThat(user.getBalance()).isEqualTo(new BigDecimal(100));
        assertThat(user.getCity()).isEqualTo("Warsaw");
    }

    @Test
    public void checkIfSavedUserRawPasswordMatchesTheEncodedPassword(){
        User user = UserCreator.createTestUser();
        String rawPassword = user.getPassword();
        userService.save(user);

        assertThat(passwordEncoder.matches(rawPassword, user.getPassword())).isTrue();
    }
}
