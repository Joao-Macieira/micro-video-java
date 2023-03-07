package com.macieira.catalog.admin.domain.category;

import com.macieira.catalog.admin.domain.validation.Error;
import com.macieira.catalog.admin.domain.validation.ValidationHandler;
import com.macieira.catalog.admin.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;
    

    public CategoryValidator(final Category category, ValidationHandler handler) {
        super(handler);
        this.category = category;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.category.getName();

        if (name == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
            return;
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Error("'name' should not be empty"));
            return;
        }

        final int lenght = name.trim().length();

        if (lenght < 3 || lenght > 255) {
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
        }
    }
    
}
