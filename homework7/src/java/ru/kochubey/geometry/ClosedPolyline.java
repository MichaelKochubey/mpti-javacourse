package ru.kochubey.geometry;

import java.util.List;

class ClosedPolyline extends Polyline {
    public ClosedPolyline(List<Point2D> points) {
        super(points);
    }

    @Override
    public int length() {
        int size = points.size();
        int res = super.length();
        res += (int) Math.sqrt(
                Math.pow(points.get(0).getX() - points.get(size - 1).getX(), 2) +
                        Math.pow(points.get(0).getY() - points.get(size - 1).getY(), 2)
        );
        return res;
    }
}
