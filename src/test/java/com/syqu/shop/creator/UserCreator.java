package com.syqu.shop.creator;

import com.syqu.shop.user.User;

import java.math.BigDecimal;

public class UserCreator {

    public static User createTestUser() {
        User testObject = new User();

        testObject.setUsername("Test");
        testObject.setPassword("longpassword123");
        testObject.setPasswordConfirm("longpassword123");
        testObject.setFirstName("Test");
        testObject.setLastName("Test");
        testObject.setAge(23);
        testObject.setEmail("randomemail@gmail.test");
        testObject.setGender("Male");
        testObject.setBalance(new BigDecimal(100));
        testObject.setCity("Warsaw");

        return testObject;
    }
}
