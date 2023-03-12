package com.macieira.catalog.admin.domain.validation.handler;

import java.util.ArrayList;
import java.util.List;

import com.macieira.catalog.admin.domain.exceptions.DomainException;
import com.macieira.catalog.admin.domain.validation.Error;
import com.macieira.catalog.admin.domain.validation.ValidationHandler;

public class Notification implements ValidationHandler {
    private final List<Error> errors;

    

    private Notification(List<Error> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Error anError) {
        return new Notification(new ArrayList<>()).append(anError);
    }

    public static Notification create(final Throwable t) {
        return create(new Error(t.getMessage()));
    }

    @Override
    public Notification append(final Error anError) {
        this.errors.add(anError);
        return this;
    }

    @Override
    public Notification append(final ValidationHandler aHandler) {
        this.errors.addAll(aHandler.getErrors());
        return this;
    }

    @Override
    public Notification validate(final Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final DomainException ex) {
            this.errors.addAll(ex.getErrors());
        } catch (final Throwable t) {
            this.errors.add(new Error(t.getMessage()));
        }
        
        return this;
    }

    @Override
    public List<Error> getErrors() {
        return this.errors;
    }
    
}
