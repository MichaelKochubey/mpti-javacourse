package ru.kochubey2;

public class Storage<T> {
    final T object;

    public Storage(T t1) {
        this.object = t1;
    }

    public T get(T other) {
        return object != null ? object : other;
    }
}

class Example2 {
    public static void main(String[] args) {
        Storage<Integer> st1 = new Storage<Integer>(null);
        test(st1, 0); // 0
        Storage<Integer> st2 = new Storage<Integer>(99);
        test(st2, -1); //99
        Storage<String> st3 = new Storage<String>(null);
        test(st3, "default"); //default
        Storage<String> st4 = new Storage<String>("hello");
        test(st4, "hello world"); //hello
    }

    public static<T> void test(Storage storage, T otherValue) {
        System.out.println(storage.get(otherValue));
    }
}
