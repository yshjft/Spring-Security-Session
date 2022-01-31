package com.springSecurity.SpringSecuritySession.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AuthoritiesValidator.class)
public @interface Authorities {
    String message() default "invalid authorities input";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
