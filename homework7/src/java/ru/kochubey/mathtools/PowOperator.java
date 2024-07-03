package ru.kochubey.mathtools;

public class PowOperator {
    public static double raiseToPower(String x, String y) {
        int x_ = Integer.parseInt(x), y_ = Integer.parseInt(y);
        return Math.pow(x_, y_);
    }
}
