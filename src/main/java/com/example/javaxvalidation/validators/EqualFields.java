package com.example.javaxvalidation.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EqualFieldsValidator.class})
public @interface EqualFields {

    String message() default "This is message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String matchField1();

    String matchField2();

    String matchField3();
}
