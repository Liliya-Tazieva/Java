import java.util.Scanner;

import static java.lang.Math.pow;

public class Hex_to_Dec {
    public static int charToint(char c){
        if(c == '1') return 1;
        else if(c == '2') return 2;
        else if(c == '3') return 3;
        else if(c == '4') return 4;
        else if(c == '5') return 5;
        else if(c == '6') return 6;
        else if(c == '7') return 7;
        else if(c == '8') return 8;
        else if(c == '9') return 9;
        else if(c == '0') return 0;
        else if(c == 'A' || c == 'a') return 10;
        else if(c == 'B' || c == 'b') return 11;
        else if(c == 'C' || c == 'c') return 12;
        else if(c == 'D' || c == 'd') return 13;
        else if(c == 'E' || c == 'd') return 14;
        else if(c == 'F' || c == 'f') return 15;
        else return -1;
    }

    public static int convert(String hex){
        int dec = 0, power = 0;
        for (int i = hex.length()-1; i >= 0; i--) {
            char c = hex.charAt(i);
            int n = charToint(c);
            if(n<0){
                System.out.println("ERROR: hexadecimal is incorrect!");
                return -1;
            }
            dec = dec + n*(int)pow(16,power);
            ++power;
        }
        return dec;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String hex;
        System.out.println("Enter hexadecimal numbers");
        hex = in.nextLine();
        int dec = convert(hex);
        System.out.println("It's decimal interpretation = "+dec);
    }
}
