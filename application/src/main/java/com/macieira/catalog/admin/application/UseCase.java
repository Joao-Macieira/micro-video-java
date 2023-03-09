package com.macieira.catalog.admin.application;

public interface UseCase<IN, OUT> {
    public abstract OUT execute(IN anIn);
}