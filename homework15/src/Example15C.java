import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

// 7.3.6
public class Example15C {
    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.setX(5);
//        TestClass proxy = cache(t); не работает
        Able proxy = cache(t);
        proxy.method2();
    }

    @SuppressWarnings("unchecked")
    public static <T> T cache(T object) {
        return (T) Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new CacheHandler(object));
    }
}

interface Able {
    public String method1();
    public void method2();
    public void setX(int x);
}

class TestClass implements Able {
    int x;

    @Override
    public String method1() {
        System.out.println("T - method1");
        return "Hello";
    }

    @Override
    @Cache
    public void method2() {
        System.out.println("T - method2; x = " + x);
    }

    @Override
    @Mutator
    public void setX(int x) {
        this.x = x;
    }
}

class CacheHandler implements InvocationHandler {
    Map<Method, Object> cache = new HashMap<>();
    Object object;

    public CacheHandler(Object obj) {
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy!");
        if (proxy == null) return object;

        Method thisMethod = object.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (thisMethod.isAnnotationPresent(Mutator.class)) cache.clear(); // т.к. объект был изменен
        if (!thisMethod.isAnnotationPresent(Cache.class)) return method.invoke(object, args);
        // если метод аннотирован, то нужно выяснить, вызывать ли его либо достать уже вычисленный результат
        if (cache.containsKey(method)) return cache.get(method);

        Object res = method.invoke(object, args);
        cache.put(method, res);
        return res;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Cache {}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface Mutator {}