package ru.kochubey.main;

import ru.kochubey.geometry.Point2D;
import ru.kochubey.geometry.Line;
import ru.kochubey.geometry.Polyline;
import ru.kochubey.mathtools.Calc;
import ru.kochubey.mathtools.Fraction;
import ru.kochubey.mathtools.PowOperator;
import ru.kochubey.mathtools.SumNumbers;

import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 4.1.2
        Point2D p1 = new Point2D(0, 0), p2 = new Point2D(1, 1), p3 = new Point2D(2, 2), p4 = new Point2D(3, 3);
        Line l1 = new Line(p1, p2), l2 = new Line(p2, p3);
        Polyline pl1 = new Polyline(List.of(p1, p2, p3)), pl2 = new Polyline(List.of(p2, p3, p4));
        System.out.println("calc length::: " + Calc.calcLength(List.of(l1, l2, pl1, pl2)));

        // 4.1.3
        BigInteger b1 = new BigInteger("12345678912345678912");
        double res = SumNumbers.calculateSum(List.of(7.0, 3.21, b1.doubleValue()), List.of(new Fraction(11, 3)));
        System.out.println("calc sum::: " + res);

        // 4.1.4
        System.out.println("pow::: " + PowOperator.raiseToPower(args[0], args[1]));

        // 4.1.5
        java.awt.Point p = new java.awt.Point(1, 1);
        Point2D pp = new Point2D(1, 1);
        System.out.println("points::: " + p + " | " + pp);
    }
}
