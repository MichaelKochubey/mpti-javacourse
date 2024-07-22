import java.util.ArrayList;
import java.util.List;

// 5.3.3
public class ExThree {
    public static<T> T method(List<T> list, Reducable<T> r) {
        return r.apply(list);
    }

    public static void main(String[] args) {
        System.out.println(
                method(List.of("qwerty", "asdfg", "zx"), new R1())
        );
        System.out.println(
                method(List.of(1, -3, 7), new R2())
        );
        System.out.println(
                method(List.of(List.of(1,3,5), List.of(11,13,15), List.of(-5, -3, -1)), new R3())
        );
    }
}

class R1 implements Reducable<String> {
    @Override
    public String apply(List<String> list) {
        StringBuilder res = new StringBuilder();
        for (String s : list) {
            res.append(s);
        }
        return res.toString();
    }
}

class R2 implements Reducable<Integer> {
    @Override
    public Integer apply(List<Integer> list) {
        int sum = 0;
        for (int x : list) sum+=x;
        return sum;
    }
}

class R3 implements Reducable<List<Integer>> {
    @Override
    public List<Integer> apply(List<List<Integer>> list) {
        List<Integer> l = new ArrayList<>();
        // ? 
        return l;
    }
}