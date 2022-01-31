package com.springSecurity.SpringSecuritySession.annotation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.MessageFormat;

@Component
public class AuthoritiesValidator implements ConstraintValidator<Authorities, String[]> {

    @Override
    public boolean isValid(String[] authorities, ConstraintValidatorContext context) {
        if(authorities == null || authorities.length == 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    MessageFormat.format("not null", null)
            ).addConstraintViolation();
            return false;
        }

        for(String authority : authorities) {
            if(authority.equals("ROLE_USER") || authority.equals("ROLE_ADMIN")) continue;

            context.disableDefaultConstraintViolation();
            // detail reason 들어가게 된다
            context.buildConstraintViolationWithTemplate(
                    MessageFormat.format("only ROLE_USER and ROLE_ADMIN", null)
            ).addConstraintViolation();
            return false;
        }

        return true;
    }
}
