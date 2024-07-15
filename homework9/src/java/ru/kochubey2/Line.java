package ru.kochubey2;

import ru.kochubey.geometry.ILine;
import ru.kochubey.geometry.Point3D;
import ru.kochubey.geometry.Pointable;
import ru.kochubey.geometry.Point2D;

import java.util.Objects;

public class Line<T extends Pointable> implements ILine, Cloneable {
    private T start;
    private T end;

    private Line(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public static<K extends Pointable> Line<K> createOf(K start, K end) {
        return new Line<K>(start, end);
    }

    public static Line<Point2D> createOf(int x1, int y1, int x2, int y2) {
        Point2D start = new Point2D(x1, y1);
        Point2D end = new Point2D(x2, y2);
        return new Line<Point2D>(start, end);
    }

    public int length() {
        return start.lengthTo(end);
    }

    public T getStart() {
        return start;
    }

    public void setStart(T p1) {
        this.start = (T) p1.clone();
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T p1) {
        this.end = (T) p1.clone();
    }

    @Override
    public String toString() {
        return "{" + start.toString() + "," + end.toString() + '}';
    }

    // 3.4.3
    @Override
    public boolean equals(Object other) {
        if ((other == null) || (other.getClass() != this.getClass())) return false;
        if (this == other) return true;

        Line<T> l = (Line<T>) other;
        return Objects.equals(this.start, l.start) && Objects.equals(this.end, l.end);
    }

    @Override
    public Line<T> clone() {
        T st = (T) this.start.clone();
        T end = (T) this.end.clone();
        return new Line<T>(st, end);
    }
}

class Example4 {
    public static void main(String[] args) {
        Point3D p1 = new Point3D(1, 2, 3), p2 = new Point3D(3, 1, 2);
        Line<Point3D> line = Line.createOf(p1, p2);
        System.out.println(line);
        moveLine(line);
        System.out.println(line);
    }

    // 5.2.1
    public static<T extends Pointable> void moveLine(Line<T> line) {
        T start = line.getStart();
        int x = start.getX();
        start.setX(x - 10);
    }
}