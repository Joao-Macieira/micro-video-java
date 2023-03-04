package com.macieira.catalog.admin.application;

import com.macieira.catalog.admin.domain.category.Category;

public class UseCase {
    public Category execute() {
        return new Category();
    }
}