package ru.kochubey.geometry;

import java.util.Objects;

public class Point2D implements Pointable<Point2D> {
    private int x;
    private int y;

    public Point2D() {
        this(0, 0);
    }

    public Point2D(int x, int y) {
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
        // if (!(other instanceof Point2D p)) return false;
        if (this == other) return true;

        Point2D q = (Point2D) other;
        return Objects.equals(this.x, q.x) && Objects.equals(this.y, q.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    // 4.2.4
    @Override
    public Point2D clone() {
        try {
            return (Point2D) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public int lengthTo(Point2D p) {
        return (int) Math.sqrt(Math.pow(this.x - p.x, 2) +
                Math.pow(this.y - p.y, 2));
    }
}
