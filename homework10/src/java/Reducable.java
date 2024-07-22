import java.util.List;

public interface Reducable<T> {
    public T apply(List<T> list);
}
