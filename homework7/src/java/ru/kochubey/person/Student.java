package ru.kochubey.person;

import java.util.Arrays;

class Student {
    String name;
    int[] marks;

    public Student() {
        this("", new int[]{});
    }
    public Student(String name) {
        this(name, new int[]{});
    }
    public Student(String name, int[] marks) {
        this.name = name;
        for (int x : marks) {
            if ((x < 2) || (x > 5)) throw new IllegalArgumentException("Mark doesn't exist");
        }
        this.marks = marks;
    }
    public int[] getMarks() {
        return marks;
    }
    @Override
    public String toString() {
        return "Name: " + name + "[" + Arrays.toString(marks) + "]";
    }

    public double getAverage() {
        if (marks.length == 0) return 0.0;
        else if (marks.length == 1) return marks[0];
        else {
            double sum = 0.0;
            for (int x : marks) {
                sum += x;
            }
            return sum / marks.length;
        }
    }
    public boolean isTop() {
        if (marks.length == 0) return false;
        else {
            for (int x : marks) {
                if (x < 5) return false;
            }
            return true;
        }
    }
    public void addMark(int x) {
        if ((x < 2) || (x > 5)) throw new IllegalArgumentException("Mark doesn't exist");
        int [] newMarks = new int[marks.length + 1];
        for (int i = 0; i < marks.length; i ++) {
            newMarks[i] = marks[i];
        }
        newMarks[marks.length] = x;
        this.marks = newMarks;
    }
}
