public class Example13 {
    public static void main(String[] args) {
        int x = 5, y = 10;
        System.out.println("counting sum of " + x + " and " + y);
        Storage<Integer> st = Tmp.countSum(5, 10);
        System.out.println("before get(), st.object = " + st.object); // null, т.к. не записывали значение в переменную
        System.out.println(st.getObj(0));
        System.out.println("after , st.object = " + st.object);
    }
}

interface ValueSupplier<T> {
    T supply();
}

class Storage<T> {
    T object;
    ValueSupplier<T> function;

    public Storage(T t1) {
        this.object = t1;
    }
    public Storage(ValueSupplier<T> supplier) {
        this.function = supplier;
    }

    public T getObj(T other) {
        this.object = function.supply();
        return object != null ? object : other;
    }
}

class Tmp {
    public static Storage<Integer> countSum(int x, int y) {
        return new Storage<>(() -> x + y);
    }
}