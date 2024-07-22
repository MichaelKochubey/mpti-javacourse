import java.util.ArrayList;
import java.util.List;

// 5.3.2
public class ExTwo {
    public static<T> List<T> method(List<T> list, Testable<T> ts) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (ts.test(t)) {
                newList.add(t);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        System.out.println(
                method(List.of("qwerty", "asdfg", "zx"), new T1())
        );
        System.out.println(
                method(List.of(1, -3, 7), new T2())
        );
        System.out.println(
                method(List.of(List.of(-1,-3,-5), List.of(11,13,15), List.of(-5, -3, 1)), new T3())
        );
    }
}

class T1 implements Testable<String> {
    @Override
    public boolean test(String s) {
        return s.length() > 3;
    }
}

class T2 implements Testable<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer < 0;
    }
}

class T3 implements Testable<List<Integer>> {
    @Override
    public boolean test(List<Integer> integers) {
        for (int i : integers) {
            if (i > 0) return false;
        }
        return true;
    }
}