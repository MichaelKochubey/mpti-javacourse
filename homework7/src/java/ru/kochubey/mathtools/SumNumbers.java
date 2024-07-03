package ru.kochubey.mathtools;

import java.util.List;

// 3.3.1
public class SumNumbers {
    public static double calculateSum(List<Double> numbers, List<Fraction> fractions) {
        double res = 0;
        for (double d: numbers) {
            res += d;
        }
        for (Fraction f: fractions) {
            res += f.toDouble();
        }
        return res;
    }
}
