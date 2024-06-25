// 3.3.5
import java.util.ArrayList;
import java.util.List;

class Calc {
    static int calcLength(List<ALine> lines) {
        int res = 0;
        for (ALine a : lines) {
            res += a.length();
        }
        return res;
    }
}

abstract class ALine {
    List<Point> points;

    public ALine(List<Point> points) {
        this.points = points;
    }

    int length() {
        int res = 0;
        for (int i = 1; i < points.size(); i ++) {
            res += (int) Math.sqrt(
                    Math.pow(points.get(i).getX() - points.get(i - 1).getX(), 2) +
                            Math.pow(points.get(i).getY() - points.get(i - 1).getY(), 2));
        }
        return res;
    }
}

class Line5 extends ALine {
    public Line5(Point p1, Point p2) {
        super(List.of(p1, p2));
    }
}

class Polyline5 extends ALine {
    public Polyline5(List<Point> points) {
        super(points);
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        Point p1 = new Point(0,0), p2 = new Point(1,1), p3 = new Point(2,2), p4 = new Point(3,3),p5 = new Point(0,5);
        Line5 l1 = new Line5(p1, p2), l2 = new Line5(p1, p3);
        Polyline5 pl1 = new Polyline5(List.of(p1 ,p2, p3)), pl2 = new Polyline5(List.of(p2, p4, p5));
        List<ALine> lines = new ArrayList<ALine>(List.of(l1, l2, pl1, pl2));
        System.out.println(Calc.calcLength(lines));
    }
}
