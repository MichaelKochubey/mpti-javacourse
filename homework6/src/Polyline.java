//3.1.2 - 1.5.7 - 1.4.9 - 1.3.2

import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

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
        sb.append("Line [ ");
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

class ClosedPolyline extends Polyline {
    public ClosedPolyline(List<Point> points) {
        super(points);
        closeLine(points.get(0));
    }

    public void closeLine(Point p) {
        List<Point> ps = new ArrayList<>(getPoints());
        ps.add(p);
        setPoints(ps);
    }

    @Override
    public void addPoints(List<Point> p) {
        int size = getPoints().size();
        List<Point> newPoints = new ArrayList<>();
        // p1 p2 p3 p1 + p5 -> p1 p2 p3 p5 p1
        for (int i = 0; i < size - 1; i ++) {
            newPoints.add(getPoints().get(i));
        }
        newPoints.addAll(p);
        newPoints.add(getPoints().get(size - 1)); // замыкание
        setPoints(newPoints);
    }

    @Override
    public int length() {
        return 0;
    }
}

class ExampleOne {
    public static void main(String[] args) {
        Point p1 = new Point(1 ,5), p2 = new Point(2, 8), p3 = new Point(5, 3), p4 = new Point(2, -5), p5 = new Point(4, -8);

        ClosedPolyline cpl1 = new ClosedPolyline(List.of(p1, p2, p3));
        System.out.println(cpl1);
        cpl1.addPoints(List.of(p4, p5));
        System.out.println(cpl1);
    }
}