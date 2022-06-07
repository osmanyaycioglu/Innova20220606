package com.innova.training.spring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {StartWithImpl.class })
public @interface StartWith {
    String value();

    String message() default "String ${value} ile başlamalı";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
