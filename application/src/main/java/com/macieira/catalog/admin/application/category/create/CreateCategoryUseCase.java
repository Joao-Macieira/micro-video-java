package com.macieira.catalog.admin.application.category.create;

import com.macieira.catalog.admin.application.UseCase;
import com.macieira.catalog.admin.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {}
