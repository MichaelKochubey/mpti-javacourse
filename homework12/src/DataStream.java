import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataStream<T> {
    private List<T> list;
    private List<Operation> commands = new ArrayList<>();

    public DataStream(List<T> list) {
        this.list = list;
    }

    public static <T> DataStream<T> create(List<T> list) {
        return new DataStream<>(list);
    }

    public <V> DataStream<V> map(Transformable<T, V> mapper) {
        commands.add(new Transformer<>(mapper));
        return (DataStream<V>) this;
    }

    public DataStream<T> filter(Checkable<T> checker) {
        commands.add(new Checker<>(checker));
        return this;
    }

    public Optional<T> reduce(Reducer<T> reducer) {
        for (Operation command : commands) {
            for (int i = 0; i < list.size(); i++) {
                command.act(list.get(i));
            }
            list = command.getList();
        }

        if (list.isEmpty()) return Optional.empty();

        T res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = reducer.make(res, list.get(i));
        }
        return Optional.of(res);
    }

    public<V> Optional<V> collect(CollectionCreator<V> creator, CollectionGatherer<V, T> gatherer) {
        V resList = creator.create();
        for (Operation command : commands) {
            for (int i = 0; i < list.size(); i++) {
                command.act(list.get(i));
            }
            list = command.getList();
        }
        if (list.isEmpty()) return Optional.empty();

        for (int i = 0; i < list.size(); i++) {
            gatherer.add(resList, list.get(i));
        }
        return Optional.of(resList);
    }
}

class Example12 {
    public static void main(String[] args) {
        List<String> list1 = List.of("a", "ab", "abc", "abcde", "xyzzz");
        Integer res = DataStream
                .create(list1)
                .filter(x -> x.length() > 3)
                .map(x -> x.length())
                .reduce((x, y) -> x+y)
                .orElse(0);

        List<String> list2 = List.of("121", "55", "abc", "abcde", "40");
        List<Integer> res2 = DataStream
                .create(list2)
                .filter(x -> canBeConvertedToInt(x))
                .map(x -> Integer.parseInt(x))
                .collect(ArrayList<Integer>::new, ArrayList::add)
                .orElse(new ArrayList<>());

        System.out.println(res);
        System.out.println(res2);
    }

    // Метод, который проверяет, можно ли строку преобразовать в int
    private static boolean canBeConvertedToInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

// интерфейс, который описывает действие само по себе
interface Operation<T> {
    void act(T t);
    List getList();
}

// класс, который воплощает действие в смысле проверки какого-либо значения
class Checker<T> implements Operation<T> {
    // поле, которое отвечает за проверку. Ссылка - интерфейс, так как здесь используется функция не конкретной реализации,
    // а лишь отвечающая требованиям (какие - см. Checkable)
    private Checkable<T> predicate;
    private List<T> resultOfChecking = new ArrayList<>();
    public Checker(Checkable<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public void act(T t) {
        if (predicate.check(t)) resultOfChecking.add(t);
    }

    @Override
    public List<T> getList() {
        return resultOfChecking;
    }
}

// класс, который воплощает действие в смысле функции, преобразующей какое-либо значение
class Transformer<T, V> implements Operation<T> {
    // поле, отвечающее за преобразование
    private Transformable<T, V> mapper;
    private List<V> resultOfMapping = new ArrayList<>();
    public Transformer(Transformable<T, V> mapper) {
        this.mapper = mapper;
    }

    @Override
    public void act(T t) {
        resultOfMapping.add(mapper.map(t));
    }

    @Override
    public List<V> getList() {
        return resultOfMapping;
    }
}

// интерфейс, описывающий идею о функции, преобразующей значение из одного класса в другой
interface Transformable<T, V> {
    V map(T t);
}

// интерфейс, описывающий множество функций, которые могут быть использованы в качестве проверочных к классу
// каких-либо объектов
interface Checkable<T> {
    boolean check(T t);
}

// интерфейс Reducer используется для того, чтобы описать функцию, которая возвращает
// объект класса Т, основываясь на двух объектах класса Т
interface Reducer<T> {
    T make(T t, T t2);
}

interface CollectionGatherer<P, T> {
    void add(P list, T val);
}

interface CollectionCreator<T> {
    T create();
}
