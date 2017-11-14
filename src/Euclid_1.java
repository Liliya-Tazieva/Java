import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.floorMod;

public class Euclid_1 {
    public static int gcd1(int a, int b){
        while (b!=0){
            int r = b;
            b = a%b;
            a = r;
        }
        return a;
    }

    public static int gcd2(int a, int b){
        while (b!=0){
            int r = b;
            b = floorMod(a,b);
            a = r;
        }
        return a;
    }

    public static int gcd3(int a, int b){
        while (b!=0){
            int r = b;
            b = abs(a%b);
            a = r;
        }
        return a;
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
