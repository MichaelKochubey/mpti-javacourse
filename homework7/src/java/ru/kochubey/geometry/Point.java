package ru.kochubey.geometry;

import java.util.Objects;

public class Point implements Cloneable {
    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + ';' + y + '}';
    }

    // 3.4.2
    @Override
    public boolean equals(Object other) {
        if (other == null || (other.getClass() != this.getClass())) return false;
        // if (!(other instanceof Point p)) return false;
        if (this == other) return true;

        Point q = (Point) other;
        return Objects.equals(this.x, q.x) && Objects.equals(this.y, q.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    // 4.2.4
    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
