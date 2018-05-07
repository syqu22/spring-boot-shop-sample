package com.syqu.shop.product;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title","error.not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.not_empty");

        // Title must have from 2 characters to 32
        if (product.getName().length() <= 1) {
            errors.rejectValue("title", "product.error.title.less_2");
        }
        if (product.getName().length() > 32) {
            errors.rejectValue("title", "product.error.title.over_32");
        }
    }
}
