package com.solvd.laba.interfaces.functional;

@FunctionalInterface
public interface ICall<T, K> {
    K callPhoneNumber(T t);
}
