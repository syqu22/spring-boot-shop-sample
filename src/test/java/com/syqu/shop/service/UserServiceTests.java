package com.syqu.shop.service;

import com.syqu.shop.creator.UserCreator;
import com.syqu.shop.domain.User;
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
    public void checkIfUserServiceIsNotNull(){
        initMocks(this);

        assertThat(userService).isNotNull();
    }

    @Test
    public void saveUserTests(){
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
        assertThat(found.getUsername()).isEqualTo(UserCreator.USERNAME);
        assertThat(found.getEmail()).isEqualTo(UserCreator.EMAIL);
        assertThat(found.getAge()).isEqualTo(UserCreator.AGE);
        assertThat(found.getGender()).isEqualTo(UserCreator.GENDER);
    }

    @Test
    public void whenFindByUsernameThenReturnUser() {
        initMocks(this);

        when(userService.findByUsername(UserCreator.USERNAME)).thenReturn(UserCreator.createTestUser());
        User found = userService.findByUsername(UserCreator.USERNAME);

        assertThat(found.getUsername()).isEqualTo(UserCreator.USERNAME);
        assertThat(found.getEmail()).isEqualTo(UserCreator.EMAIL);
        assertThat(found.getAge()).isEqualTo(UserCreator.AGE);
        assertThat(found.getGender()).isEqualTo(UserCreator.GENDER);
    }

    @Test
    public void whenFindByEmailThenReturnUser() {
        initMocks(this);

        when(userService.findByEmail(UserCreator.EMAIL)).thenReturn(UserCreator.createTestUser());
        User found = userService.findByEmail(UserCreator.EMAIL);

        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo(UserCreator.USERNAME);
        assertThat(found.getEmail()).isEqualTo(UserCreator.EMAIL);
        assertThat(found.getAge()).isEqualTo(UserCreator.AGE);
        assertThat(found.getGender()).isEqualTo(UserCreator.GENDER);
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
}
