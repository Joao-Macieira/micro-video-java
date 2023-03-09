package com.macieira.catalog.admin.application;

public abstract class UseCase<IN, OUT> {
    public abstract OUT execute(IN anIn);
}