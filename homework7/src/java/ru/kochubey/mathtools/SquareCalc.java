package ru.kochubey.mathtools;

import ru.kochubey.geometry.Figure;

import java.util.List;

// 3.3.3
public class SquareCalc {
    public static int calc(List<Figure> figures) {
        int res = 0;
        for (Figure f : figures) {
            res += f.square();
        }
        return res;
    }
}