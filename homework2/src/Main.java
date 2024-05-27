public class Main {
    public static void main(String[] args) {
        System.out.println("fraction : " + Utils.fraction(5.25) + " " + Utils.fraction(52.78));
        System.out.println("sumLastNums : " + Utils.sumLastNums(5) + " " + Utils.sumLastNums(-122) + " " + Utils.sumLastNums(6443580));
        System.out.println("is2Digits : " + Utils.is2Digits(1) + " " + Utils.is2Digits(12) + " " + Utils.is2Digits(432));
        System.out.println("isUpperCase : " + Utils.isUpperCase('F') + " " + Utils.isUpperCase('w'));
        System.out.println("isInRange : " + Utils.isInRange(10, 20, 15) + " " + Utils.isInRange(20, 0, 15));
        System.out.println("isDivisor : " + Utils.isDivisor(10, -2) + " " + Utils.isDivisor(10, 25));
        System.out.println("isEqual : " + Utils.isEqual(2, 2, 2) + " " + Utils.isEqual(1, 3, 3));

        int sum =  Utils.lastNumSum(Utils.lastNumSum(Utils.lastNumSum(Utils.lastNumSum(5, 11), 123),14), 1);
        System.out.println("sum = " + sum);
    }
}

class Utils {
    public static double fraction(double x) {
        return x % 1;
    }

    public static int sumLastNums(int x) {
        if (!isPositive(x)) x = -x;
        if (x / 100 < 1) return 0;
        else {
            return x % 10 + x % 100 / 10;
        }
    }

    public static int charToNum(char x) {
        return (int) x - (int) '0';
    }

    public static boolean isPositive(int x) {
        return x >= 0;
    }

    public static boolean is2Digits(int x) {
        if (!isPositive(x)) x = -x;
        return (1 <= x / 10) && (x / 10 < 10);
    }

    public static boolean isUpperCase(char x) {
        return ('A' <= x) && (x <= 'Z');
    }

    public static boolean isInRange(int a, int b, int num) {
        if (a > b) {int t = a; a = b; b = t;}
        return (a <= num) && (num <= b);
    }

    public static boolean isDivisor(int a, int b) {
        return a % b == 0 || b % a == 0;
    }

    public static boolean isEqual(int a, int b, int c) {
        return (a == b) && (b == c);
    }

    public static int lastNumSum(int a, int b) {
        return a%10 + b%10;
    }
}