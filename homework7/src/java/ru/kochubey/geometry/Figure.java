package ru.kochubey.geometry;

// 3.2.4
public abstract class Figure {
    Point2D start;
    int side;
    public abstract int square();

    public Figure(Point2D start, int side) {
        this.start = start;
        this.side = side;
    }
}
