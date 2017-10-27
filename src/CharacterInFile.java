import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterInFile {
    public static void main(String[] args) {
        String path = args[0];
        char c = args[1].charAt(0);
        String line = "";
        int count = 0;

        try {
            InputStreamReader file = new InputStreamReader(new FileInputStream(path), "UTF-8");
            BufferedReader data = new BufferedReader(file);

            while ((line = data.readLine()) != null)
                for (int i = 0; i < line.length(); i++)
                    if (line.charAt(i) == c)
                        count++;

            System.out.println(count);
        }
        catch (IOException e) {
            System.out.println("main: " + e.getMessage());
        }
    }
}