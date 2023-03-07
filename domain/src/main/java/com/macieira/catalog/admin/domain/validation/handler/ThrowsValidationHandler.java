package com.macieira.catalog.admin.domain.validation.handler;

import java.util.List;

import com.macieira.catalog.admin.domain.exceptions.DomainException;
import com.macieira.catalog.admin.domain.validation.Error;
import com.macieira.catalog.admin.domain.validation.ValidationHandler;

public class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append(Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(ValidationHandler aHandler) {
        throw DomainException.with(aHandler.getErrors());
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }

    @Override
    public ValidationHandler validate(Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(new Error(ex.getMessage()));
        }

        return this;
    }
    
}
