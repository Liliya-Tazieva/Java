import java.util.Scanner;

public class Palindrome_10 {

    public static void main(String args[]) {
        //Initialize input
        System.out.println("Enter string that contains at least 1 character");
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("");
        String totalString = "", first, second, previous_char, current_char = "";

        //Read 1st character, which is always a palindrome, into string, which will contain 1st half of input string
        first = scan.next();
        System.out.println("Current string: " + first + " is a palindrome");
        //If possible read 2nd character into string, which will contain 2nd half of input string
        second = scan.next();
        if (second.equals("\n")) return;

        //Initialize complete input string, count hash for 1st and 2nd halves
        totalString = first + second;
        previous_char = second;
        int i = 1, hash_first, hash_second;
        hash_first = first.hashCode();
        hash_second = second.hashCode();

        //Check whether input string is a palindrome from the 3rd character onward
        while (true) {
            boolean is_palindrome = false;
            //Compare whether 1st and 2nd halves' hashes are equal
            if (hash_first == hash_second) {
                if (first.equals(second)) is_palindrome = true;
            }
            //Declare current input string a palindrome or not based on comparison above
            System.out.print("Current string: " + totalString);
            if (is_palindrome) System.out.print(" is a palindrome\n");
            else System.out.print(" isn't a palindrome\n");

            //Check whether the input terminated
            current_char = scan.next();
            if (current_char.equals("\n")) break;
            //If input carry on, change 1st and 2nd halves for the next iteration
            totalString += current_char;

            //If i is even then add next character after 1st half at beginning of 'first'
            //and add next character after 2nd half at the end of 'second'
            if (i % 2 == 0) {
                first = previous_char + first;
                second += current_char;
            }
            //If i is odd then keep 'first' the same,
            //remove 1st character of 'second' and add next character after 2nd half at the end of 'second',
            //save removed character in 'previous_char', to add it to 'first' on the next iteration
            else {
                previous_char = "" + second.charAt(0);
                second = second.substring(1);
                second += current_char;
            }
            //Count new hash
            hash_first = first.hashCode();
            hash_second = second.hashCode();
            ++i;
        }
        return;
    }
}
