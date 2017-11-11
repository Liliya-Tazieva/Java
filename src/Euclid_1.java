import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.floorMod;

public class Euclid_1 {
    public static int gcd1(int a, int b) {
        b = abs(b);
        a = abs(a);
        if (b > a) {
            if ((b % a) == 0)
                return a;
            else
                return gcd1(a, b % a);
        } else {
            if ((a % b) == 0)
                return b;
            else
                return gcd1(b, a % b);
        }
    }

    public static int gcd2(int a, int b) {
        b = abs(b);
        a = abs(a);
        if (b > a) {
            if (floorMod(b, a) == 0)
                return a;
            else
                return gcd2(a, floorMod(b, a));
        } else {
            if ((a % b) == 0)
                return b;
            else
                return gcd2(b, floorMod(a, b));
        }
    }

    public static int rem(int m, int n) {
        m = abs(m);
        n = abs(n);
        if (m > n) return m % n;
        else return n % m;
    }

    public static int gcd3(int a, int b) {
        int r = rem(a, b);
        if (b > a) {
            if (rem(b, a) == 0)
                return a;
            else
                return gcd3(a, rem(b, a));
        } else {
            if ((a % b) == 0)
                return b;
            else
                return gcd3(b, rem(a, b));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        System.out.println("Enter numbers");
        a = in.nextInt();
        b = in.nextInt();
        System.out.println("The greatest common divisor with % " + gcd1(a, b));
        System.out.println("The greatest common divisor with floorMod() " + gcd2(a, b));
        System.out.println("The greatest common divisor with rem() " + gcd3(a, b));
    }
}
