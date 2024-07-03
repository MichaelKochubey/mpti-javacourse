package ru.kochubey.geometry;

// наследуем прямоугольник от квадрата - и добавляем прямоугольнику длину другой стороны
class Rectangle extends Square {
    int secondSide;

    public Rectangle(Point leftHighPoint, int firstSide, int secondSide) {
        super(leftHighPoint, firstSide);
        this.secondSide = secondSide;
    }

    @Override
    public int square() {
        return side * secondSide;
    }
}
