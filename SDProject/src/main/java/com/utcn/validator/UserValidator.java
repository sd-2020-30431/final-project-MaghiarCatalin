package com.utcn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.Objects;

@Component
public class UserValidator {

    public String getErrorMessage(FieldError errorField) {
        String fieldName = errorField.getField();
        String errorMessage;
        switch (fieldName) {
            case "email":
                errorMessage = "Invalid email format!";
                break;
            case "password":
                errorMessage = "Your password must have minimum eight characters, at least one " +
                        "uppercase letter, one lowercase letter, one number and one special character (@$!%*?&)";
                break;
            default:
                errorMessage = this.getErrorMessageFromCode(Objects.requireNonNull(errorField.getCode()));
        }
        return errorMessage;
    }

    private String getErrorMessageFromCode(String errorCode) {
        if (errorCode.equals("Pattern")) {
            return "This field contains invalid characters!";
        } else {
            return "This field cannot be empty!";
        }
    }
}
