import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

// 7.3.4
public class Example15B {
    public static void main(String[] args) throws Exception {
        Slavonic ryurik = new Slavonic("Ryurik", 1000, 190, 80, "M", Tribe.Vyatichi);
        Germanic attila = new Germanic("Attila", 30, 250, 100, "M", Tribe.Krivichi);
        validate(ryurik, attila);
    }

    public static void validate(Object ...obj) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Object o: obj) {
            if (!o.getClass().isAnnotationPresent(Validate.class)) continue;
            Validate v = o.getClass().getAnnotation(Validate.class);
            Class<?>[] testClasses = v.value();
            for (Class c : testClasses) {
                Object testObj = c.getConstructor().newInstance();
                for (Method method : c.getDeclaredMethods()) {
                    try {
                        method.invoke(testObj, o);
                    } catch (InvocationTargetException e) {
                        System.out.println(e.getTargetException().getMessage());
                    }
                }
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@interface Validate {
    Class<?>[] value();
}

enum Tribe { Dregovichi, Vyatichi, Krivichi, Francs, Saxs, Turks, Balts }

class Human {
    String name;
    int age, height, weight;
    String gender;
    Tribe tribe;

    public Human(String name, int age, int height, int weight, String gender, Tribe tribe) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.tribe = tribe;
    }
}

@Validate(SlavonicTest.class)
class Slavonic extends Human {
    public Slavonic(String name, int age, int height, int weight, String gender, Tribe tribe) {
        super(name, age, height, weight, gender, tribe);
    }
}

class SlavonicTest {
    public SlavonicTest(){}
    void testName(Slavonic slav) throws Exception {
        if (slav.name == null)
            throw new Exception("testName: Должно человеку имя имати");
    }
    void testAge(Slavonic slav) throws Exception {
        if ((slav.age < 0) || (slav.age > 100))
            throw new Exception("testAge: Сия людина то ли не родилася, али уже въ могиле почиваетъ");
    }
    void testHeight(Slavonic slav) throws Exception {
        if ((slav.height < 40) || (slav.height > 300))
            throw new Exception("testHeight: Не можетъ человече ниже пня быти, такъ и выше дуба зеленаго стати");
    }
    void testWeight(Slavonic slav) throws Exception {
        if ((slav.weight < 0) || (slav.weight > 150))
            throw new Exception("testWeight: Дабы Мать Сыра Земля на себе носила, надобно весъ имати, али всхуднути");
    }
    void testGender(Slavonic slav) throws Exception {
        if (!(slav.gender.equals("M")) && !(slav.gender.equals("W")))
            throw new Exception("testGender: Не бывать на Руси нехристямъ поганимъ, имъ геена огнена уготована");
    }
    void checkTribe(Slavonic slav) throws Exception {
        if ((slav.tribe == Tribe.Francs) || (slav.tribe == Tribe.Balts) || (slav.tribe == Tribe.Turks) || (slav.tribe == Tribe.Saxs))
            throw new Exception("checkTribe: Ступай восвояси - на Руси басурманамъ не бывати");
    }
}

@Validate(GermanicTest.class)
class Germanic extends Human {
    public Germanic(String name, int age, int height, int weight, String gender, Tribe tribe) {
        super(name, age, height, weight, gender, tribe);
    }
}

class GermanicTest {
    public GermanicTest(){}
    void testName(Germanic germ) throws Exception {
        if (germ.name == null)
            throw new Exception("testName: Person muss einen Namen haben");
    }
    void testAge(Germanic germ) throws Exception {
        if ((germ.age < 0) || (germ.age > 115))
            throw new Exception("testAge: Person muss ein echtes Alter haben");
    }
    void testHeight(Germanic germ) throws Exception {
        if ((germ.height < 40) || (germ.height > 300))
            throw new Exception("testHeight: Person muss wahrheitsgemäßes Wachstum haben");
    }
    void testWeight(Germanic germ) throws Exception {
        if ((germ.weight < 0) || (germ.weight > 170))
            throw new Exception("testWeight: Person muss ein gutes Gewicht haben");
    }
    void testGender(Germanic germ) throws Exception {
        if (!(germ.gender.equals("M")) && !(germ.gender.equals("W")))
            throw new Exception("testGender: nur Männer und Frauen");
    }
    void checkTribe(Germanic germ) throws Exception {
        if ((germ.tribe != Tribe.Francs) && (germ.tribe != Tribe.Saxs))
            throw new Exception("checkTribe: das ist unser Land !!!");
    }
}