package com.macieira.catalog.admin.domain;

import com.macieira.catalog.admin.domain.validation.ValidationHandler;

public class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id) {
        super(id);
    }

    @Override
    public void validate(ValidationHandler handler) {
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
    
}
