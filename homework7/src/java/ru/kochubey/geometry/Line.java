package ru.kochubey.geometry;

import java.util.Objects;

public class Line implements ILine {
    private Point2D start;
    private Point2D end;

    public Line(Point2D start, Point2D end) {
        this.start = start.clone();
        this.end = end.clone();
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point2D(x1, y1);
        this.end = new Point2D(x2, y2);
    }

    public int length() {
        return (int) Math.sqrt(Math.pow(this.end.getX() - this.start.getX(), 2) +
                Math.pow(this.end.getY() - this.start.getY(), 2));
    }

    public Point2D getStart() {
        return start;
    }

    public void setStart(Point2D start) {
        this.start = start;
    }

    public Point2D getEnd() {
        return end;
    }

    public void setEnd(Point2D end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + start.toString() + "," + end.toString() + '}';
    }

    // 3.4.3
    @Override
    public boolean equals(Object other) {
        if ((other == null) || (other.getClass() != this.getClass())) return false;
        if (this == other) return true;

        Line l = (Line) other;
        return Objects.equals(this.start, l.start) && Objects.equals(this.end, l.end);
    }

    // 4.2.5
    @Override
    public Line clone() {
        try {
            return (Line) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
