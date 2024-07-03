package ru.kochubey.geometry;

// не наследуемся ни от кого - достаточно задать точки
class Triangle {
    Point start;
    Point two;
    Point three;

    public Triangle(Point start, Point two, Point three) {
        this.start = start;
        this.two = two;
        this.three = three;
    }

    int square() {
        return 1; // тут место для формулы
    }
}