import java.util.ArrayList;
import java.util.List;

// 5.3.1
public class ExOne {
    public static <T, P> List<P> method(List<T> list, Applicable<T, P> op) {
        List<P> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(op.apply(t));
        }
        return newList;
    }

    public static void main(String[] args) {
        System.out.println(
                method(List.of("qwerty", "asdfg", "zx"), new F1())
        );
        System.out.println(
                method(List.of(1, -3, 7), new F2())
        );
        System.out.println(
                method(List.of(List.of(1,3,5), List.of(11,13,15), List.of(-5, -3, -1)), new F3())
        );
    }
}

class F1 implements Applicable<String, Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}

class F2 implements Applicable<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer < 0 ? integer * -1 : integer;
    }
}

class F3 implements Applicable<List<Integer>, Integer> {
    @Override
    public Integer apply(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int x : list) {
            max = x > max ? x : max;
        }
        return max;
    }
}
