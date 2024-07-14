package ru.kochubey.geometry;

class Square extends Figure {
    public Square(Point2D leftHighPoint, int side) {
        super(leftHighPoint, side);
    }

    @Override
    public int square() {
        return side * side;
    }
}
