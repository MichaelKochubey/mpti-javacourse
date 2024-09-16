import ru.kochubey.geometry.Point2D;
import ru.kochubey.geometry.Polyline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example14 {
    public static void main(String[] args) throws FileNotFoundException {
        // 1
        Stream<Point2D> stream = Stream
                .of(new Point2D(1, 1), new Point2D(-1, 3), new Point2D(4, 2), new Point2D(-5, -1), new Point2D(-1, -3));
        Polyline pl = stream
                .sorted((p1, p2) -> {return p1.getX() - p2.getX();})
                .peek((point) -> point.setY(Math.abs(point.getY())))
                .distinct()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Polyline::new
                ));
        System.out.println(pl);

        // 2
        Scanner sc = new Scanner(new File("homework14/test.txt"));
        Map<String, List<String>> map0 = Stream
                .generate(sc::next)
                .takeWhile(line -> sc.hasNextLine())
                .map((str) -> {
                   String s = str.toLowerCase();
                   return (s.charAt(0)+"").toUpperCase() + s.substring(1);
                })
                .filter(str -> str.split(":").length > 1)
                .collect(Collectors.groupingBy(str -> str.split(":")[1]));
        System.out.println(map0);
    }
}

