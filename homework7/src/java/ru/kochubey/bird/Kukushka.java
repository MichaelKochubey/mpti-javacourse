package ru.kochubey.bird;

public class Kukushka extends Bird {
    @Override
    void sing() {
        int N = (int) (Math.random() * 10);
        for (int i = 0; i < N; i ++) {
            System.out.println("ku-ku");
        }
    }
}
