package ru.kochubey.bird;

public class Popugai extends Bird {
    String singText;
    public Popugai(String singText) {
        this.singText = singText;
    }

    @Override
    void sing() {
        int N = (int) (Math.random() * (singText.length() - 1)) + 1;
        System.out.println(this.singText.substring(0, N));
    }
}
