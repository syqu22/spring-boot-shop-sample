package com.syqu.shop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        //Username and password can't me empty or contain whitespace
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");

        // Username must have from 4 characters to 32
        if (user.getUsername().length() < 4) {
            errors.rejectValue("username", "UsernameLengthLess4");
        }if(user.getUsername().length() > 32){
            errors.rejectValue("username","UsernameLengthOver32");
        }
        //Username can't be duplicated
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "DuplicatedUsername");
        }
        //Email can't be duplicated
        if (userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email","DuplicatedEmail");
        }
        //Password must have at least 8 characters and max 32
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "PasswordLengthLess8");
        }
        if (user.getPassword().length() > 32){
            errors.rejectValue("password","PasswordLengthOver32");
        }
        //Password must be the same as the confirmation password
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "DiffPasswordConfirm");
        }

        //Age needs to be higher than 13
        if (user.getAge() <= 13){
            errors.rejectValue("age","AgeSize");
        }
    }
}
