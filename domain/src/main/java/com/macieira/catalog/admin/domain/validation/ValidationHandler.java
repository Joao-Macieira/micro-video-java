package com.macieira.catalog.admin.domain.validation;

import java.util.List;

public interface ValidationHandler {
    ValidationHandler append(Error anError);
    ValidationHandler append(ValidationHandler aHandler);
    ValidationHandler validate(Validation aValidation);
    List<Error> getErrors();

    default boolean hasErrors() {
        return getErrors() != null && !(getErrors().isEmpty());
    }

    default Error firstError() {
        if (getErrors() != null && !getErrors().isEmpty()) {
            return getErrors().get(0);
        }

        return null;
    }

    public interface Validation {
        void validate();
    }
}
