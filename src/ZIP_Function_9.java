import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ZIP_Function_9 {

    public static <T> Stream<T> Zip(Stream<T> a, Stream<T> b){
        Spliterator<T> aSpliterator = a.spliterator();
        Spliterator<T> bSpliterator = b.spliterator();

        Iterator<T> aIterator = Spliterators.iterator(aSpliterator);
        Iterator<T> bIterator = Spliterators.iterator(bSpliterator);

        Iterator<T> resultIterator = new Iterator<T>() {
            boolean a_is_first = true;

            @Override
            public boolean hasNext() {
                return aIterator.hasNext() && bIterator.hasNext() || a_is_first && aIterator.hasNext() || !a_is_first && bIterator.hasNext();
            }

            @Override
            public T next() {
                if (a_is_first) {
                    a_is_first = false;
                    return aIterator.next();
                }
                a_is_first = true;
                return bIterator.next();
            }
        };

        int characteristics = aSpliterator.characteristics() & bSpliterator.characteristics() &
                ~(Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.SIZED);

        Spliterator<T> resultSpliterator = Spliterators.spliteratorUnknownSize(resultIterator, characteristics);
        if(a.isParallel() || b.isParallel()) return StreamSupport.stream(resultSpliterator, true);
        else return StreamSupport.stream(resultSpliterator, false);
    }
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("c");
        a.add("e");
        a.add("g");

        List<String> b = new ArrayList<>();
        b.add("b");
        b.add("d");
        b.add("f");
        b.add("h");
        b.add("j");
        b.add("l");

        System.out.println(Zip(a.stream(),b.stream()).map(String::toString).collect(Collectors.joining(", ")));
    }
}
