package ru.kochubey.geometry;

class Circle extends Figure {
    public Circle(Point2D center, int radius) {
        super(center, radius);
    }

    @Override
    public int square() {
        return (int) (Math.PI * side * side);
    }
}
