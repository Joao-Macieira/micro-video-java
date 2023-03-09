package com.macieira.catalog.admin.application;

public interface UnitUseCase<IN> {
    public abstract void execute(IN anIn);
}
