package ru.kochubey.mathtools;

import java.util.Objects;

public class Fraction extends Number implements Cloneable {
    private final int numerator;
    private final int denominator;
    public Fraction() {
        this(1,1);
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / (float) denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / (double) denominator;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator must not be equal to zero");
        if (denominator < 0) { numerator = numerator * -1; denominator = denominator * -1;}
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public Fraction inverse() {
        return new Fraction(this.denominator, this.numerator);
    }
    public Fraction sum(Fraction f) {
        int d1 = this.getDenominator(), d2 = f.getDenominator();
        int coefForFrst = 1, coefForScnd = 1, commonDen = d1;
        if (d1 != d2) {
            commonDen = d1 * d2 / findGreatestCommonDenominator(d1, d2);
            coefForFrst = commonDen / d1;
            coefForScnd = commonDen / d2;
        }
        int resNum = this.getNumerator() * coefForFrst + f.getNumerator() * coefForScnd;
        return new Fraction(resNum, commonDen);
    }
    public Fraction minus(Fraction f) {
        Fraction f2 = new Fraction(-1 * f.getNumerator(), f.getDenominator());
        return this.sum(f2);
    }
    public Fraction mult(Fraction f) {
        return new Fraction(this.numerator * f.numerator, this.denominator * f.denominator);
    }
    public Fraction div(Fraction f) {
        return this.mult(f.inverse());
    }
    public Fraction sum(int x) {
        int den = this.denominator, num = x * den;
        return this.sum(new Fraction(num, den));
    }
    public Fraction minus(int x) {
        return this.sum(-x);
    }
    public Fraction mult(int x) {
        return new Fraction(this.numerator * x, this.denominator);
    }
    public Fraction div(int x) {
        if (x == 0) throw new IllegalArgumentException("Division by zero is forbidden");
        return new Fraction(this.numerator, this.denominator * x);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // наибольший общий делитель
    private static int findGreatestCommonDenominator(int a, int b) {
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        while (a > 0 && b > 0) {
            if (a >= b) a = a % b;
            else b = b % a;
        }
        return Math.max(a, b);
    }

    // сокращение дроби
    public Fraction reduce() {
        int a = this.getNumerator(), b = this.getDenominator();
        int c = findGreatestCommonDenominator(a, b);
        if (c > 1) {
            return new Fraction(a / c, b / c);
        }
        return this;
    }

    public double toDouble() {
        return (double) this.numerator / (double) this.denominator;
    }

    // 3.4.1
    public boolean equals(Object other) {
        if (other == null || (this.getClass() != other.getClass())) return false;
        // if (!(other instanceof Fraction fr)) return false;
        if (this == other) return true;

        Fraction f = (Fraction) other;
        return Objects.equals(this.numerator, f.numerator) && Objects.equals(this.denominator, f.denominator);
    }

    public int hashCode() {
        return Objects.hash(this.numerator, this.denominator);
    }

    // 4.2.3
    @Override
    public Fraction clone() {
        try {
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
