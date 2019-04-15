package io.pjj.paramvalidation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Component
public class BeanValidator {
    private static final String FORMAT_ERROR_MESSAGE = "%s is %s. However for %s: %s" ;
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public <T> List<String> validate(T t) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        return getMessageList(constraintViolations);
    }

    private <T> List<String> getMessageList(Set<ConstraintViolation<T>> constraintViolations) {
        List<String> messageList = new ArrayList<>();

        for (ConstraintViolation<T> violation : constraintViolations) {
            String field = violation.getPropertyPath().toString();
            String message = String.format(FORMAT_ERROR_MESSAGE,
                    field, Objects.toString(violation.getInvalidValue()),
                    field, Objects.toString(violation.getMessage())
            );
            messageList.add(message);
        }

        return messageList;
    }
}
