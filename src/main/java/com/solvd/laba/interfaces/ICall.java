package main.java.com.solvd.laba.interfaces;

@FunctionalInterface
public interface ICall<T, K> {
    K callPhoneNumber(T t);
}
