import java.util.Scanner;

public class Rot13_2 {

    public static char rot13(char c) {
        if (c >= 'a' && c <= 'm') c += 13;
        else if (c >= 'A' && c <= 'M') c += 13;
        else if (c >= 'n' && c <= 'z') c -= 13;
        else if (c >= 'N' && c <= 'Z') c -= 13;
        return c;
    }

    public static void main(String[] args) {
        String s_old = args[0];
        String s_new = "";
        for (int i = 0; i < s_old.length(); i++) {
            s_new = s_new + rot13(s_old.charAt(i));
        }
        System.out.println(s_old + " -> " + s_new);
    }
}