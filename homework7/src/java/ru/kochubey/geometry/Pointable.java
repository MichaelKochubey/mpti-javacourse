package ru.kochubey.geometry;

public interface Pointable<T> extends Cloneable {
    int lengthTo(T other);
    T clone();
    int getX();
    void setX(int x);
}
