package ru.kochubey.geometry;

import java.util.List;

// 3.3.3
class SquareCalc {
    public static int calc(List<Figure> figures) {
        int res = 0;
        for (Figure f : figures) {
            res += f.square();
        }
        return res;
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        Point p1 = new Point(0 ,0), p2 = new Point(1,1), p3 = new Point(2, 2);
        Circle c1 = new Circle(p1, 1), c2 = new Circle(p1, 2);
        Square s1 = new Square(p1, 2), s2 = new Square(p3, 3);
        System.out.println(SquareCalc.calc(List.of(c1, c2, s1, s2))); // 3 + 12 + 4 + 9
    }
}
