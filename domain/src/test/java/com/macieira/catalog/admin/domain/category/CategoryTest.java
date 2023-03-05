package com.macieira.catalog.admin.domain.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.macieira.catalog.admin.domain.exceptions.DomainException;
import com.macieira.catalog.admin.domain.validation.handler.ThrowsValidationHandler;

class CategoryTest {
    @Test
    void givenAValidParams_whenCallNewCategory_thenInstaceateACategory() {
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCateogry = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertNotNull(actualCateogry);
        Assertions.assertNotNull(actualCateogry.getId());
        Assertions.assertEquals(expectedName, actualCateogry.getName());
        Assertions.assertEquals(expectedDescription, actualCateogry.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCateogry.isActive());
        Assertions.assertNotNull(actualCateogry.getCreatedAt());
        Assertions.assertNotNull(actualCateogry.getUpdatedAt());
        Assertions.assertNull(actualCateogry.getDeletedAt());
    }

    @Test
    void givenAnInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final String expectedName = null;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }
}