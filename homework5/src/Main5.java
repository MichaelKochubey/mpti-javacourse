import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fraction {
    private int numerator;
    private int denominator;
    public Fraction() {
        this(1,1);
    }
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator must not be equal to zero");
        if (denominator < 0) { numerator = numerator * -1; denominator = denominator * -1;}
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public Fraction inverse() {
        return new Fraction(this.denominator, this.numerator);
    }
    public Fraction sum(Fraction f) {
        int d1 = this.getDenominator(), d2 = f.getDenominator();
        int coefForFrst = 1, coefForScnd = 1, commonDen = d1;
        if (d1 != d2) {
            commonDen = d1 * d2 / findGreatestCommonDenominator(d1, d2);
            coefForFrst = commonDen / d1;
            coefForScnd = commonDen / d2;
        }
        int resNum = this.getNumerator() * coefForFrst + f.getNumerator() * coefForScnd;
        return new Fraction(resNum, commonDen);
    }
    public Fraction minus(Fraction f) {
        Fraction f2 = new Fraction(-1 * f.getNumerator(), f.getDenominator());
        return this.sum(f2);
    }
    public Fraction mult(Fraction f) {
        return new Fraction(this.numerator * f.numerator, this.denominator * f.denominator);
    }
    public Fraction div(Fraction f) {
        return this.mult(f.inverse());
    }
    public Fraction sum(int x) {
        int den = this.denominator, num = x * den;
        return this.sum(new Fraction(num, den));
    }
    public Fraction minus(int x) {
        return this.sum(-x);
    }
    public Fraction mult(int x) {
        return new Fraction(this.numerator * x, this.denominator);
    }
    public Fraction div(int x) {
        if (x == 0) throw new IllegalArgumentException("Division by zero is forbidden");
        return new Fraction(this.numerator, this.denominator * x);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // наибольший общий делитель
    private static int findGreatestCommonDenominator(int a, int b) {
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        while (a > 0 && b > 0) {
            if (a >= b) a = a % b;
            else b = b % a;
        }
        return Math.max(a, b);
    }

    // сокращение дроби
    public Fraction reduce() {
        int a = this.getNumerator(), b = this.getDenominator();
        int c = findGreatestCommonDenominator(a, b);
        if (c > 1) {
            return new Fraction(a / c, b / c);
        }
        return this;
    }
}

class Line {
    private Point start;
    private Point end;
    public Line(Point start, Point end) {
        this.start = start.clone();
        this.end = end.clone();
    }
    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    public int length() {
        return (int) Math.sqrt(Math.pow(this.end.getX() - this.start.getX(), 2) +
        Math.pow(this.end.getY() - this.start.getY(), 2));
    }
    public Point getStart() {
        return start;
    }
    public void setStart(Point start) {
        this.start = start;
    }
    public Point getEnd() {
        return end;
    }
    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + start.toString() + "," + end.toString() + '}';
    }
}

class Point {
    private int x;
    private int y;
    public Point() {
        this(0,0);
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "{" + x + ';' + y + '}';
    }
    @Override
    public Point clone() {
        return new Point(this.x, this.y);
    }
}

class Student {
    String name;
    int[] marks;

    public Student() {
        this("", new int[]{});
    }
    public Student(String name) {
        this(name, new int[]{});
    }
    public Student(String name, int[] marks) {
        this.name = name;
        for (int x : marks) {
            if ((x < 2) || (x > 5)) throw new IllegalArgumentException("Mark doesn't exist");
        }
        this.marks = marks;
    }
    public int[] getMarks() {
        return marks;
    }
    @Override
    public String toString() {
        return "Name: " + name + "[" + Arrays.toString(marks) + "]";
    }

    public double getAverage() {
        if (marks.length == 0) return 0.0;
        else if (marks.length == 1) return marks[0];
        else {
            double sum = 0.0;
            for (int x : marks) {
                sum += x;
            }
            return sum / marks.length;
        }
    }
    public boolean isTop() {
        if (marks.length == 0) return false;
        else {
            for (int x : marks) {
                if (x < 5) return false;
            }
            return true;
        }
    }
    public void addMark(int x) {
        if ((x < 2) || (x > 5)) throw new IllegalArgumentException("Mark doesn't exist");
        int [] newMarks = new int[marks.length + 1];
        for (int i = 0; i < marks.length; i ++) {
            newMarks[i] = marks[i];
        }
        newMarks[marks.length] = x;
        this.marks = newMarks;
    }
}

class City {
    private String name;
    private ArrayList<Road> roads;
    public City(String name) {
        this.name = name;
    }

    public City(String name, ArrayList<Road> roads) {
        this.name = name;
        this.roads = new ArrayList<Road>(roads);
    }

    public void setRoads(List<Road> roads) {
        this.roads = new ArrayList<Road>(roads);
    }
    public void addRoad(Road road) {
        for (Road r : roads) {
            if (r.getTo().equals(road.getTo())) throw new IllegalArgumentException("Road should not be duplicated");
        }
        this.roads.add(road);
    }
    public void deleteRoadByIndex(int index) {
        this.roads.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Road r : roads) {
            sb.append(r.getTo().name + " : " + r.getPrice() + ", ");
        }
        return "{" + name + ": [" + sb.toString() + "]}";
    }
}

class Road {
    private City to;
    private int price;
    public Road(City to, int price) {
        this.to = to;
        this.price = price;
    }

    public City getTo() {
        return to;
    }
    public void setTo(City to) {
        this.to = to;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}

class Employee {
    private String name;
    private Dept dept;

    public Employee(String name) {
        this.name = name;
    }
    public Employee(String name, Dept dept) {
        this.name = name;
        this.dept = dept;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Dept getDept() {
        return dept;
    }
    public void setDept(Dept dept) {
        this.dept = dept;
    }
    @Override
    public String toString() {
        if (isHeadOfDept()) return name + " is a Head of dept " + dept.getTitle();
        return name + " works in dept " + dept.getTitle() + " where Head is " + dept.getHead().getName();
    }
    public boolean isHeadOfDept() {
        return this.name.equals(this.getDept().getHead().getName());
    }
}

class Dept {
    private String title;
    private Employee head;

    public Dept(String title) {
        this.title = title;
    }
    public Dept(String title, Employee head) {
        this.title = title;
        this.head = head;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Employee getHead() {
        return head;
    }
    public void setHead(Employee employee) {
        if (employee.getDept().equals(this)) this.head = employee;
        else throw new IllegalArgumentException("Employee must work in this dept to be the head of it");
    }
}

public class Main5 {
    public static void main(String[] args) {
        // 1.6.4
        /*
        Fraction a = new Fraction(7,11);
        Fraction b = new Fraction(1,7);
        System.out.println("7/11 + 1/7 = " + a.sum(b));

        a = new Fraction(13,23);
        b = new Fraction(17,5);
        System.out.println("13/23 - 17/5 = " + a.minus(b));

        a = new Fraction(3,5);
        b = new Fraction(8,11);
        System.out.println("3/5 * 8/11 = " + a.mult(b));
        System.out.println("3/5 / 8/11 = " + a.div(b));

        System.out.println("3/5 + 4 = " + a.sum(4));
        System.out.println("3/5 - 2 = " + a.minus(2));
        System.out.println("3/5 * 3 = " + a.mult(3));
        System.out.println("3/5 / 2 = " + a.div(2));

        a = new Fraction(4,7);
        b = new Fraction(8,11);
        Fraction c = new Fraction(4, 9);
        System.out.println("4/7 + 8/11 / 4/9 - 5 = " + a.sum(b).div(c).minus(5).reduce());

        a = new Fraction(-2, -3);
        System.out.println(a);
        a = new Fraction(2, -3);
        System.out.println(a);
         */

        // 1.6.6
        /*
        Point p1 = new Point(1,1), p2 = new Point(2,2), p3 = new Point(3,3);
        Line line1 = new Line(p1, p2), line2 = new Line(p1, p3);
        System.out.println(line1.getStart().hashCode() == line2.getStart().hashCode());
         */

        // 1.6.9
        /*
        Student st = new Student("Vasya", new int[]{3, 4, 5, 4});
        Student st2 = new Student("Petya", new int[]{5, 5, 5, 5});
        System.out.println(st);
        st.addMark(6);
        System.out.println(st);
         */

        // 1.6.10
        /*
        System.out.println("1.6.10");
        City A = new City("A"), B = new City("B"), C = new City("C"),
                D = new City("D"), E = new City("E"), F = new City("F");
        List<Road> Roads = new ArrayList<>();
        Roads.add(new Road(B, 5)); Roads.add(new Road(D, 6)); Roads.add(new Road(F, 1));
        A.setRoads(Roads); Roads.clear();

        Roads.add(new Road(A, 5)); Roads.add(new Road(C, 3));
        B.setRoads(Roads); Roads.clear();

        Roads.add(new Road(B, 3)); Roads.add(new Road(D, 4));
        C.setRoads(Roads); Roads.clear();

        Roads.add(new Road(C, 4)); Roads.add(new Road(E, 2)); Roads.add(new Road(A, 6));
        D.setRoads(Roads); Roads.clear();

        Roads.add(new Road(F, 2));
        E.setRoads(Roads); Roads.clear();

        Roads.add(new Road(B, 1)); Roads.add(new Road(E, 2));
        F.setRoads(Roads); Roads.clear();

        F.addRoad(new Road(B, 1));
        System.out.println(F);
        */

        // 1.6.11
        /*
        Dept it = new Dept("IT"); Dept it2 = new Dept("IT");
        Employee emp1 = new Employee("Petrov", it), emp2 = new Employee("Kozlov", it), emp3 = new Employee("Sidorov", it);
        Employee emp4 = new Employee("Kochubey", it2);
        it.setHead(emp4);
         */
    }
}