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
    String name;
    List<Road> roads;
}
class Road {
    City to;
    int price;
}

public class Main5 {
    public static void main(String[] args) {
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
        /*
        Point p1 = new Point(1,1), p2 = new Point(2,2), p3 = new Point(3,3);
        Line line1 = new Line(p1, p2), line2 = new Line(p1, p3);
        System.out.println(line1.getStart().hashCode() == line2.getStart().hashCode());
         */
        /*
        Student st = new Student("Vasya", new int[]{3, 4, 5, 4});
        Student st2 = new Student("Petya", new int[]{5, 5, 5, 5});
        System.out.println(st);
        st.addMark(6);
        System.out.println(st);
         */

    }
}