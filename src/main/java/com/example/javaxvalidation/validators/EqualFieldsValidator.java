package com.example.javaxvalidation.validators;

import com.example.javaxvalidation.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class EqualFieldsValidator implements ConstraintValidator<EqualFields, Object> {

    private String matchField1;
    private String matchField2;
    private String matchField3;

    @Override
    public void initialize(EqualFields constraintAnnotation) {
        matchField1 = constraintAnnotation.matchField1();
        matchField2 = constraintAnnotation.matchField2();
        matchField3 = constraintAnnotation.matchField3();

    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

        try {
            Object matchField1Value = getFieldValue(object, matchField1);
            Object matchField2Value = getFieldValue(object, matchField2);
            Object matchField3Value = getFieldValue(object, matchField3);

            /**
             * can add custom logic according to each request object in here
             */

            if (object instanceof User) {

                String userName = (String) matchField1Value;
                String email = (String) matchField2Value;
                String country = (String) matchField3Value;

                if (userName.isEmpty()) {
                    if (email.isEmpty() || country.isEmpty()) {
                        String missingField = email.isEmpty() ? "email" : " country";
                        constraintValidatorContext.disableDefaultConstraintViolation();
                        constraintValidatorContext.buildConstraintViolationWithTemplate("Both email or country are mandatory if username is empty.")
                                .addPropertyNode(missingField)
                                .addConstraintViolation();
                        return false;
                    } else {
                        return true;
                    }

                } else {
                    return true;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }
}

