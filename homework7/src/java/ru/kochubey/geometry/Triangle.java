package ru.kochubey.geometry;

// не наследуемся ни от кого - достаточно задать точки
class Triangle {
    Point2D start;
    Point2D two;
    Point2D three;

    public Triangle(Point2D start, Point2D two, Point2D three) {
        this.start = start;
        this.two = two;
        this.three = three;
    }

    int square() {
        return 1; // тут место для формулы
    }
}