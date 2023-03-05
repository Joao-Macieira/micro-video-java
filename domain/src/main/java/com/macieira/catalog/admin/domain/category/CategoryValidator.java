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
        if (this.category.getName() == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
        }
    }
    
}
