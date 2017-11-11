import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RandomLines_7 {

    public  static  void  main(String args[]){
        String path = args[0];
        int lines_to_print = Integer.parseInt(args[1]);

        File file = new File(path.toString());
        //System.out.println(file.length());
        int lines_to_store = (int) (file.length()/85)+1;
        //System.out.println(lines_to_store);
        List<String> store_list = new ArrayList<String>(lines_to_store);

        try {
            InputStreamReader file_reader = new InputStreamReader(new FileInputStream(path), "UTF-8");
            BufferedReader data = new BufferedReader(file_reader);

            for(int i = 0; i < lines_to_store; ++i){
                store_list.add(data.readLine());
            }
        } catch (IOException e) {
            System.out.println("main: " + e.getMessage());
        }

        for(int i = 0; i<lines_to_print;++i){
            int random_number = (int) (Math.random() * lines_to_store);
            System.out.println("line number "+ random_number +":"+store_list.get(random_number));
        }

    }
}
