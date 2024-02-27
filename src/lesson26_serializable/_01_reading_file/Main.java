package lesson26_serializable._01_reading_file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static final String INPUT_FILE = "src/lesson26_serializable/_01_reading_file/input.txt";
    public static final String OUTPUT_FILE = "src/lesson26_serializable/_01_reading_file/output.txt";

    public static void main(String[] args) {
//        try (Scanner sc = new Scanner(new FileInputStream(INPUT_FILE));
//             OutputStream os = new FileOutputStream(OUTPUT_FILE)){
//            while (sc.hasNextLine()) {
//                var bytes = sc.nextLine().getBytes();
//                os.write(bytes);
//                os.write("\n".getBytes(StandardCharsets.UTF_8));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (var br = new BufferedReader(new FileReader(INPUT_FILE));
            var stream = br.lines();
            var os = new FileOutputStream(OUTPUT_FILE)) {
            var collect = stream.collect(Collectors.joining("\n"));
            os.write(collect.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
