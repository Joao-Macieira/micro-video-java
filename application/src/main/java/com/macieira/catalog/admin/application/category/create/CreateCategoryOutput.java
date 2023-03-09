package com.macieira.catalog.admin.application.category.create;

import com.macieira.catalog.admin.domain.category.Category;
import com.macieira.catalog.admin.domain.category.CategoryID;

public record CreateCategoryOutput(
    CategoryID id
) {
    public static CreateCategoryOutput from(final Category aCategory) {
        return new CreateCategoryOutput(aCategory.getId());
    }
}
