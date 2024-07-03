package ru.kochubey.geometry;//3.1.2 - 1.5.7 - 1.4.9 - 1.3.2

import java.util.ArrayList;
import java.util.List;

public class Polyline implements ILine {
    List<Point> points;

    public Polyline() {
        points = List.of(new Point(0, 0));
    }

    public Polyline(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }

    public void setPoints(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public void addPoints(List<Point> p) {
        List<Point> newPoints = new ArrayList<>();
        newPoints.addAll(points);
        newPoints.addAll(p);
        points = newPoints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ru.kochubey.geometry.Line [ ");
        for (Point p : points) {
            sb.append(p.toString());
        }
        sb.append("] \n");
        return sb.toString();
    }

    public int length() {
        int res = 0;
        for (int i = 1; i < points.size(); i ++) {
            res += (int) Math.sqrt(
                    Math.pow(points.get(i).getX() - points.get(i - 1).getX(), 2) +
                    Math.pow(points.get(i).getY() - points.get(i - 1).getY(), 2)
            );
        }
        return res;
    }
}