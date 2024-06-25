// 3.2.4
abstract public class Figure {
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

class Rectangle extends Figure {
    int secondSide;

    public Rectangle(Point leftHighAngle, int firstSide, int secondSide) {
        super(leftHighAngle, firstSide);
        this.secondSide = secondSide;
    }

    @Override
    int square() {
        return side * secondSide;
    }
}

class Square extends Rectangle {
    public Square(Point leftHighAngle, int side) {
        super(leftHighAngle, side, side);
    }
}

class Triangle extends Figure{
    Point two;
    Point three;

    public Triangle(Point start, Point two, Point three, int side) {
        super(start, 0);
        this.two = two;
        this.three = three;
    }

    @Override
    int square() {
        return 1; // тут место для формулы
    }
}

class Example3 {
    public static void main(String[] args) {

    }
}