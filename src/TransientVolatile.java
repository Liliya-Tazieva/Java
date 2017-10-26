import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TransientVolatile {

    public static boolean containsKeyWord(Path file, String word) {
        try {
            return Files.lines(file).anyMatch(line -> line.contains(word));
        } catch (IOException e) {
            System.out.println("containsKeyWord: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            Path dir = Paths.get("C:\\Java\\JDK_src");
            Files.walk(dir)
                    .filter(arg -> !Files.isDirectory(arg))
                    .filter(arg -> containsKeyWord(arg, "volatile"))
                    .filter(arg -> containsKeyWord(arg, "transient"))
                    .forEachOrdered(arg -> System.out.println(arg));
        } catch (IOException e) {
            System.out.println("main: " + e.getMessage());
        }
    }
}
