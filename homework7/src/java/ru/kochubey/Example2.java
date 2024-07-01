package ru.kochubey;

// 3.2.3
abstract class Bird {
    abstract void sing();
    public Bird() {}
}

class Vorobey extends Bird {
    @Override
    void sing() {
        System.out.println("chyryk");
    }
}

class Kukushka extends Bird {
    @Override
    void sing() {
        int N = (int) (Math.random() * 10);
        for (int i = 0; i < N; i ++) {
            System.out.println("ku-ku");
        }
    }
}

class Popugai extends Bird {
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

public class Example2 {
    public static void main(String[] args) {
        Vorobey v = new Vorobey();
        v.sing();
        Kukushka k = new Kukushka();
        k.sing();
        Popugai p = new Popugai("Na samom interesnom meste");
        p.sing();
    }
}