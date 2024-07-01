package ru.kochubey.geometry;

// 3.2.4
abstract class Figure {
    Point start;
    int side;
    abstract int square();

    public Figure(Point start, int side) {
        this.start = start;
        this.side = side;
    }
}

class Circle extends Figure {
    public Circle(Point center, int radius) {
        super(center, radius);
    }

    @Override
    int square() {
        return (int) (Math.PI * side * side);
    }
}

// наследуем прямоугольник от квадрата - и добавляем прямоугольнику длину другой стороны
class Rectangle extends Square {
    int secondSide;

    public Rectangle(Point leftHighPoint, int firstSide, int secondSide) {
        super(leftHighPoint, firstSide);
        this.secondSide = secondSide;
    }

    @Override
    int square() {
        return side * secondSide;
    }
}

class Square extends Figure {
    public Square(Point leftHighPoint, int side) {
        super(leftHighPoint, side);
    }

    @Override
    int square() {
        return side * side;
    }
}

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

public class Example3 {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Square sq1 = new Square(p1, 2);
        Rectangle r1 = new Rectangle(p1, 2 ,3);
        System.out.println(sq1.square());
        System.out.println(r1.square());
    }
}