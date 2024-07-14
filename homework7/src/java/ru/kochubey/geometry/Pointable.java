package ru.kochubey.geometry;

public interface Pointable<T> extends Cloneable {
    int lengthTo(T other);
    T clone();
}
