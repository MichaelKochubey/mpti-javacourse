package ru.kochubey2;

public class Storage<T> {
    final T object;
    final T other;

    public Storage(T t1, T t2) {
        this.object = t1;
        this.other = t2;
    }

    public T get() {
        return object != null ? object : other;
    }
}

class Example2 {
    public static void main(String[] args) {
        Storage<Integer> st1 = new Storage<Integer>(null, 0);
        test(st1); // 0
        Storage<Integer> st2 = new Storage<Integer>(99, -1);
        test(st2); //99
        Storage<String> st3 = new Storage<String>(null, "default");
        test(st3); //default
        Storage<String> st4 = new Storage<String>("hello", "hello world");
        test(st4); //hello
    }

    public static void test(Storage storage) {
        System.out.println(storage.get());
    }
}
