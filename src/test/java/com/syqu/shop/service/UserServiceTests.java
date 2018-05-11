package com.syqu.shop.service;

import com.syqu.shop.creator.UserCreator;
import com.syqu.shop.user.User;
import com.syqu.shop.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @MockBean
    private UserService userService;

    @Test
    public void saveUserTests(){
        initMocks(this);

        User user = UserCreator.createTestUser();
        userService.save(user);
        when(userService.findById(user.getId())).thenReturn(user);
        User found = userService.findById(user.getId());

        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo(user.getUsername());
        assertThat(found.getEmail()).isEqualTo(user.getEmail());
        assertThat(found.getAge()).isEqualTo(user.getAge());
        assertThat(found.getGender()).isEqualTo(user.getGender());
    }

    @Test
    public void whenFindByIdThenReturnUser() {
        when(userService.findById(100L)).thenReturn(UserCreator.createTestUser());
        User found = userService.findById(100L);

        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("Test");
        assertThat(found.getEmail()).isEqualTo("randomemail@gmail.test");
        assertThat(found.getAge()).isEqualTo(23);
        assertThat(found.getGender()).isEqualTo("Male");
    }

    @Test
    public void whenFindByUsernameThenReturnUser() {
        initMocks(this);

        when(userService.findByUsername("Test")).thenReturn(UserCreator.createTestUser());
        User found = userService.findByUsername("Test");

        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("Test");
        assertThat(found.getEmail()).isEqualTo("randomemail@gmail.test");
        assertThat(found.getAge()).isEqualTo(23);
        assertThat(found.getGender()).isEqualTo("Male");
    }

    @Test
    public void whenFindByEmailThenReturnUser() {
        initMocks(this);

        when(userService.findByEmail("randomemail@gmail.test")).thenReturn(UserCreator.createTestUser());
        User found = userService.findByEmail("randomemail@gmail.test");

        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("Test");
        assertThat(found.getEmail()).isEqualTo("randomemail@gmail.test");
        assertThat(found.getAge()).isEqualTo(23);
        assertThat(found.getGender()).isEqualTo("Male");
    }

    @Test
    public void whenFindByIdAndNoUserThenReturnNull(){
        User found = userService.findById(25L);

        assertThat(found).isNull();
    }

    @Test
    public void whenFindByUsernameAndNoUserThenReturnNull(){
        User found = userService.findByUsername("Tests");

        assertThat(found).isNull();
    }

    @Test
    public void whenFindByEmailAndNoUserThenReturnNull(){
        User found = userService.findByEmail("example@donut.org");

        assertThat(found).isNull();
    }

    //TODO Add User Login
}
