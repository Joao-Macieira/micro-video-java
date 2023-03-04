package com.macieira.catalog.admin.domain.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}