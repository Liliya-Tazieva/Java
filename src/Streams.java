import java.io.InputStream;
import java.text.BreakIterator;
import java.util.Scanner;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static class intStream_from_Scanner{
        Scanner input;
        IntSupplier supplier = () -> {
            return input.nextInt();
        };
        intStream_from_Scanner(InputStream in) {
            input = new Scanner(in);
        }
        IntStream stream(){
            return IntStream.generate(supplier);
        }
    }

    public static class doubleStream_from_Scanner{
        Scanner input;
        DoubleSupplier supplier = () -> {
            return input.nextDouble();
        };
        doubleStream_from_Scanner(InputStream in) {
            input = new Scanner(in);
        }
        DoubleStream stream(){
            return DoubleStream.generate(supplier);
        }
    }

    public static class lineStream_from_Scanner{
        Scanner input;
        Supplier<String> supplier = () -> {
            return input.nextLine();
        };
        lineStream_from_Scanner(InputStream in) {
            input = new Scanner(in);
        }
        Stream<String> stream(){
            return Stream.generate(supplier);
        }
    }

    public static class wordStream_from_Scanner{
        Scanner input;
        BreakIterator wordFinder;
        String contents;
        Supplier<String> supplier = () -> {
            if (contents.length() == 0)
                contents = input.nextLine();

            wordFinder.setText(contents);
            int start = wordFinder.first();
            int end = wordFinder.next();

            String word = contents.substring(start, end);

            if (end != contents.length())
                ++end;

            contents = contents.substring(end);

            return word;
        };

        wordStream_from_Scanner(InputStream in) {
            input = new Scanner(in);
            wordFinder = BreakIterator.getWordInstance();
            contents = "";
        }
        Stream<String> stream(){
            return Stream.generate(supplier);
        }
    }

    public static void main(String[] args){
        /*IntStream stream_int = new intStream_from_Scanner(System.in).stream();
        stream_int.forEach(arg -> System.out.println(arg));

        DoubleStream stream_double = new ioubleStream_from_Scanner(System.in).stream();
        stream_double.forEach(arg -> System.out.println(arg));

        Stream<String> stream_line = new lineStream_from_Scanner(System.in).stream();
        stream_line.forEach(arg -> System.out.println(arg));*/

        Stream<String> stream_str = new wordStream_from_Scanner(System.in).stream();
        stream_str.forEach(arg -> System.out.println(arg));
    }
}
