// 3.3.5
import java.util.ArrayList;
import java.util.List;

class Calc {
    static int calcLength(List<ILine> lines) {
        int res = 0;
        for (ILine a : lines) {
            res += a.length();
        }
        return res;
    }
}

// этот интерфейс реализуют класс Polyline и homework5/src/Line
interface ILine {
    int length();
}

public class Exercise5 {
    public static void main(String[] args) {
        Point p1 = new Point(0,0), p2 = new Point(1,1), p3 = new Point(2,2), p4 = new Point(3,3),p5 = new Point(0,5);
        Line l1 = new Line(p1, p2), l2 = new Line(p1, p3);
        Polyline pl1 = new Polyline(List.of(p1 ,p2, p3)), pl2 = new Polyline(List.of(p2, p4, p5));
        List<ILine> lines = new ArrayList<ILine>(List.of(l1, l2, pl1, pl2));
        System.out.println(Calc.calcLength(lines));
    }
}
