package ru.kochubey.mathtools;// 3.3.5

import ru.kochubey.geometry.ILine;

import java.util.List;

class Calc {
    static int calcLength(List<ILine> lines) {
        int res = 0;
        for (ILine a : lines) {
            res += a.length();
        }
        return res;
    }
}