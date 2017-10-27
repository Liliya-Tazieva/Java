import java.util.stream.Stream;
import static java.lang.Math.*;

public class RandomNumbers {
    public static long RandomNumb(long a, long c, long m, long threshold){
        return (int) ((a * threshold + c) % m);
    }

    public static void main(String args[]){
        long a = 25214903917L, c = 11L, m = (long) pow(2,48);
        Stream<Long> numbers = Stream.iterate(125252L, arg  ->  RandomNumb(a,c,m,arg)).limit(20);
        numbers.forEach(System.out::println);
    }
}
