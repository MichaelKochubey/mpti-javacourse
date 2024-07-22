package ru.kochubey2;

import ru.kochubey.geometry.Point3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private T object;

    public Box(T t) {
        this.object = t;
    }

    public void put(T other) {
        if (isEmpty()) {
            object = other;
        }
        else throw new IllegalArgumentException("Box is not empty");
    }

    public T get() {
        T obj = object;
        object = null;
        return obj;
    }

    public boolean isEmpty() {
        return object == null;
    }
}

class Example1 {
    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>(3);
        Box<Double> b2 = new Box<>(4.0);
        Box<Long> b3 = new Box<>(2L);
        Box<Float> b4 = new Box<>(5f);
        List<Box<? extends Number>> list = List.of(b2, b3, b4);
        System.out.println(findMax(list));

        put3D(b1);
        System.out.println(b1.get());
    }

    public static void test(Box box) {
        int x = (int) box.get();
        System.out.println(x);
    }

    // 5.2.2
    public static double findMax(List<Box<? extends Number>> boxes) {
        double max = Double.MIN_VALUE;
        for (Box<? extends Number> box : boxes) {
            double x = box.get().doubleValue();
            max = x > max ? x : max;
        }
        return max;
    }

    // 5.2.3
    public static<T> void put3D(Box box) {
        Point3D p = new Point3D(1,1,1);
        box.get();
        box.put(p);
    }

    // 5.2.4 ?
    public static void fill(List<? super Integer> list) {
        list.clear();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }
}