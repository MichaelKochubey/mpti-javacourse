import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Start {
    public static void main(String[] args) {
        Tools t = new Tools();
        t.asserting();
/*
        System.out.println("printDays:::");
        Tools.printDays("Четверг");

        System.out.println("\n" + "square:::");
        Tools.square(3);

        System.out.println("\n" + "leftTriangle:::");
        Tools.leftTriangle(4);

        System.out.println("\n" + "rightTriangle:::");
        Tools.rightTriangle(5);

        System.out.println("\n" + "guessGame:::");
        Tools.guessGame();
 */
        // Tools.concat(new int[]{1,2}, new int[]{3,4,5,6,7});
        // int[] tmp = Tools.findAll(new int[]{1,4,2,7,0,2,5,2}, 9);
        // int[] tmp = Tools.deleteNegative(new int[]{-1,4,2,-7,0,2,5,-2});
        // int[] tmp = Tools.add(new int[]{1,2,3,4,5,6}, 100, 5);
        // int[] tmp = Tools.add(new int[]{1,2,3,4,5,6}, new int[]{-1,-2, -3}, 2);

        //for(int x:tmp) System.out.print(x+" ");
    }

}

class Tools {
    // 3
    public static int abs(int x) {
        return x > 0 ? x : -x;
    }

    public static int safeDiv(int x, int y) {
        return y != 0 ? x / y : 0;
    }

    public static int max(int x, int y) {
        return x >= y ? x : y;
    }

    public static String makeDecision(int x, int y) {
        if (x == y) return x + " == " + y;
        else {
            if (x > y) return x + " > " + y;
            else return x + " < " + y;
        }
    }

    public static int max3(int x, int y, int z) {
        return max(max(x, y), z);
    }

    public static boolean sum3(int x, int y, int z) {
        return (x + y == z) || (x + z == y) || (y + z == x);
    }

    public static int sum2(int x, int y) {
        int sum = x + y;
        return sum >= 10 && sum <= 19 ? 20 : sum;
    }

    public static boolean is35(int x) {
        return x % 3 == 0 ^ x % 5 == 0;
    }

    public static boolean magic6(int x, int y) {
        return x == 6 || y == 6 || x + y == 6 || abs(x - y) == 6;
    }

    public static boolean in(int x, int[] arr) {
        for (int a : arr) {
            if (x == a) return true;
        }
        return false;
    }
    public static String age(int x) {
        int[] ost = {2, 3, 4};
        int[] arr = {12, 13, 14};
        int y = x % 10;

        if (x != 11 && y == 1) return x + " год";
        else if (!in(x, arr) && in(y, ost)) return x + " года";
        else return x + " лет";
    }

    public static String day(int x) {
        return switch (x) {
            case 1 -> "Понедельник";
            case 2 -> "Вторник";
            case 3 -> "Среда";
            case 4 -> "Четверг";
            case 5 -> "Пятница";
            case 6 -> "Суббота";
            case 7 -> "Воскресенье";
            default -> "Это не день недели";
        };
    }

    public static void printDays(String x) {
        String[] days = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};

        int from = 10;
        for (int i = 0; i < days.length; i++) {
            if (x == days[i]) {
                from = i;
                for (int j = from; j < days.length; j++){
                    System.out.println(days[j]);
                }
                break;
            }
        }

        if (from == 10) {
            System.out.println("Это не день недели");
        }
    }

    // 4
    public static String listNums(int x) {
        char[] r = new char[2 * x + 1];
        for (int i = 0; i < x; i ++) {
            r[2 * i] = Integer.toString(i).charAt(0);
            r[2 * i + 1] = ' ';
        }
        r[2 * x] = Integer.toString(x).charAt(0);
        return new String(r);
    }

    public static String reverseListNums(int x) {
        char[] r = new char[2 * x + 1];
        for (int i = 0; i < x; i ++) {
            r[2 * i] = Integer.toString(x - i).charAt(0);
            r[2 * i + 1] = ' ';
        }
        r[2 * x] = '0';
        return new String(r);
    }

    public static String chet(int x) {
        char[] r = new char[x + 1 - x%2];
        r[0] = '0';
        for (int i = 1; i < x; i += 2) {
            r[i] = ' ';
            r[i + 1] = Integer.toString(i + 1).charAt(0);
        }
        return new String(r);
    }

    public static int pow(int x, int y) {
        int res = 1, count = 1;
        while (count <= y) {
            res *= x;
            count++;
        }
        return res;
    }

    public static int numLen(long x) {
        int num = 1;
        while (x > 10) {
            x /= 10;
            num++;
        }
        return num;
    }

    public static boolean equalNum(int x) {
        x = abs(x);
        if (x > 10) {
            int n = numLen(x);
            int num = x % 10;
            x = x / 10;
            for (int i = 0; i < n - 1; i++) {
                if (x % 10 == num) x /= 10;
                else return false;
            }
            return true;
        }
        else return false;
    }

    public static void square(int x) {
        for (int i = 0; i < x; i ++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void leftTriangle(int x) {
        for (int i = 0; i < x; i ++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void rightTriangle(int x) {
        for (int i = 0; i < x; i ++) {
            for (int j = 0; j < x - i - 1; j ++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j ++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void guessGame() {
        int count = 0;
        while (true) {
            int randomNum = 3;
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.println("What number am I thinking (0 to 9)? :");
            int x = sc.nextInt();
            count++;
            if (x != randomNum) {
                System.out.println("No, try again");
            } else {
                System.out.println("Yes, it`s " + randomNum + "; You tried " + count + " times");
                break;
            }
        }
    }

    // 5
    public static int findFirst(int[] arr, int x) {
        int index = 0;
        for (int a: arr) {
            if (x == a) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int findLast(int[] arr, int x) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                index = i;
            }
        }
        return index;
    }

    public static int maxAbs(int[] arr) {
        int max = 0;
        for (int x : arr) {
            max = abs(x) > abs(max) ? x : max;
        }
        return max;
    }

    public static int countPositive(int[] arr) {
        int count = 0;
        for (int x : arr) {
            if (x > 0) count++;
        }
        return count;
    }

    public static boolean palindrom(int[] arr) {
        int len = arr.length;
        int j = len - 1;
        for (int i = 0; i < len/2; i++, j--) {
            if (arr[i] != arr[j]) return false;
        }
        return true;
    }

    public static void reverse(int[] arr) {
        int len = arr.length;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i ++) {
            tmp[i] = arr[i];
        }
        for (int i = 0; i < len; i ++) {
            arr[len - i - 1] = tmp[i];
        }
    }

    public static int[] reverseBack(int[] arr) {
        int len = arr.length;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i ++) {
            tmp[i] = arr[len - i - 1];
        }
        return tmp;
    }

    public static int[] concat(int[] arr1, int[] arr2) {
        int[] tmp = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i ++) {
            tmp[i] = arr1[i];
        }
        int j = 0;
        for (int i = arr1.length; i < tmp.length; i ++, j ++) {
            tmp[i] = arr2[j];
        }

        for (int x : tmp) System.out.print(x + " ");
        return tmp;
    }

    public static int[] findAll(int[] arr, int x) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < arr.length; i ++) {
            if (x == arr[i]) tmp.add(i);
        }
        return tmp.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] deleteNegative(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int x : arr) {
            if (x >= 0) res.add(x);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] add(int[] arr, int x, int pos) {
        if (pos > arr.length) pos = arr.length;
        int[] tmp = new int[arr.length + 1];

        for (int i = 0; i < pos; i ++) {
            tmp[i] = arr[i];
        }
        tmp[pos] = x;
        for (int i = pos + 1; i < tmp.length; i ++) {
            tmp[i] = arr[i - 1];
        }
        return tmp;
    }

    public static int[] add(int[] arr, int[] ins, int pos) {
        if (pos > arr.length) pos = arr.length;
        int[] tmp = new int[arr.length + ins.length];

        for (int i = 0; i < pos; i ++) {
            tmp[i] = arr[i];
        }
        for (int i = pos, j = 0; j < ins.length; i ++, j ++) {
            tmp[i] = ins[j];
        }
        for (int i = pos + ins.length, j = pos; i < tmp.length; i ++, j ++) {
            tmp[i] = arr[j];
        }
        return tmp;
    }

    @Test
    public void asserting() {
        assertEquals(abs(4), 4);
        assertEquals(abs(-5), 5);

        assertEquals(safeDiv(5,1), 5);
        assertEquals(safeDiv(5,0), 0);

        assertEquals(max(1, 10), 10);

        assertEquals(makeDecision(1, 3), "1 < 3");
        assertEquals(makeDecision(4, 4), "4 == 4");

        assertEquals(max3(1, 2, 3), 3);
        assertEquals(max3(5, 7, 7), 7);

        assertTrue(sum3(3, 2, 1));
        assertFalse(sum3(10, 5, 4));

        assertEquals(sum2(5, 13), 20);
        assertEquals(sum2(15, 15), 30);

        assertTrue(is35(10));
        assertTrue(is35(18));
        assertFalse(is35(15));
        assertFalse(is35(7));

        assertTrue(magic6(4, 10));
        assertTrue(magic6(6, 1));
        assertFalse(magic6(10, 10));

        assertEquals(age(5), "5 лет");
        assertEquals(age(21), "21 год");
        assertEquals(age(43), "43 года");
        assertEquals(age(13), "13 лет");

        assertEquals(day(5), "Пятница");
        assertEquals(day(8), "Это не день недели");

        assertEquals(listNums(6), "0 1 2 3 4 5 6");
        assertEquals(reverseListNums(5), "5 4 3 2 1 0");

        assertEquals(chet(9), "0 2 4 6 8");
        assertEquals(chet(8), "0 2 4 6 8");

        assertEquals(pow(2, 4), 16);
        assertEquals(pow(5, 4), 625);

        assertEquals(numLen(6), 1);
        assertEquals(numLen(936), 3);

        assertTrue(equalNum(99999));
        assertFalse(equalNum(454444));

        assertEquals(findFirst(new int[]{5, 4, 0}, 2), -1);
        assertEquals(findFirst(new int[]{10, -5, 16, 22}, 22), 3);

        assertEquals(findLast(new int[]{5, 4, 0, 12, -7, 4, 55}, 4), 5);
        assertEquals(findLast(new int[]{10, -5, 16, 22, 22, 11, -5}, -5), 6);

        assertEquals(maxAbs(new int[]{-100, 2, 3, 1, 5}), -100);
        assertEquals(maxAbs(new int[]{-100, 200, 3, 1, 5}), 200);

        assertEquals(countPositive(new int[]{-100, 200, 3, 1, 5}), 4);
        assertEquals(countPositive(new int[]{-100, -200, -3, -1, -5}), 0);

        assertTrue(palindrom(new int[]{1, 2, 3, 3, 2, 1}));
        assertTrue(palindrom(new int[]{1, 2, 3, -6, 15, -6, 3, 2, 1}));
        assertFalse(palindrom(new int[]{1, 2, 3, -6, 0, 2, 1}));

    }
}