package ru.kochubey.mathtools;

import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;

public class PowOperator {
    public static double raiseToPower(String x, String y) {
        int x_ = parseInt(x), y_ = parseInt(y);
        return pow(x_, y_);
    }
}
