import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// 7.3.2
public class Example15 {
    public static void main(String[] args) throws IllegalAccessException {
        Q q = new Q();
        Z z = new Z();
        reset(q, z);
        System.out.println(q);
        System.out.println(z);
    }

    public static void getDefaultValue(Object o, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.getType() == String.class) field.set(o, "default");
        if (field.getType() == Integer.class) field.set(o, 777);
        if (field.getType() == int.class) field.set(o, 777);
        if (field.getType() == Double.class) field.set(o, 1.1);
        if (field.getType() == double.class) field.set(o, 1.1);
        if (field.getType() == Q.class) field.set(o, null);
        if (field.getType() == Object.class) field.set(o, new Object());
    }

    public static void reset(Object ...obj) throws IllegalAccessException {
        for (Object o : obj) {
            Class<?> c = o.getClass();
            if (o.getClass().isAnnotationPresent(Default.class)) { // если аннотирован класс
                for (Field field : c.getDeclaredFields()) {
                    getDefaultValue(o, field);
                }
            } else {
                for (Field field : c.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Default.class)) { // если аннотировано поле
                        getDefaultValue(o, field);
                    }
                }
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface Default {}

@Default
class Q {
    String s;
    int x;
    A a;
    Object ob;

    @Override
    public String toString() {
        return "A{ s=" + s + ", x=" +x +", a=" + a + ", ob=" + ob + '}';
    }
}

class Z {
    @Default
    String s;

    int x;

    @Default
    double d;

    Object ob;

    @Override
    public String toString() {
        return "Z{ s=" + s + ", x=" +x +", d=" + d + ", ob=" + ob + '}';
    }
}
