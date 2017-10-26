import java.util.Scanner;

public class Euclid {
    public static int gcd(int n, int m) {

        if (m > n) {
            if ((m % n) == 0)
                return n;
            else
                return gcd(n, m % n);
        } else {
            if ((n % m) == 0)
                return m;
            else
                return gcd(m, n % m);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        System.out.println("Enter numbers");
        m = in.nextInt();
        n = in.nextInt();
        System.out.println("The greatest common divisor " + gcd(m, n));
    }
}
