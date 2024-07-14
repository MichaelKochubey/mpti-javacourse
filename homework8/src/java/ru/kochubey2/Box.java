package ru.kochubey2;

public class Box<T> {
    private T object;

    public Box(T t) {
        this.object = t;
    }

    public void put(T other) {
        if (isEmpty()) {
            object = other;
        }
        else System.out.println("Box is not empty");
    }

    public T get() {
        T obj = object;
        object = null;;
        return obj;
    }

    public boolean isEmpty() {
        return object != null;
    }
}

class Example1 {
    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>(3);
        test(b1);
    }

    public static void test(Box box) {
        int x = (int) box.get();
        System.out.println(x);
    }
}