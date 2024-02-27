package lesson27_xml._01_training.utils;

import lesson27_xml._01_training.exeptions.TxtException;
import lesson27_xml._01_training.model.CsvCat;
import lombok.experimental.UtilityClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
public class CsvCatUtils {
    public static final String PATH_TO_FILE = "src/lesson27_xml/_01_training/resourcrces/cats.csv";

    public static List<CsvCat> extractFromFile() {
        var cats = new ArrayList<CsvCat>();
        try (var sc = new Scanner(new FileInputStream(PATH_TO_FILE))){
            while (sc.hasNextLine()) {
                try {
                    cats.add(CsvCatFactory.getInstance(sc.nextLine()));
                } catch (TxtException e) {
                    System.err.println(e);
                    System.err.println("Message: " + e.getCause().getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found!!!");
        }
        return cats;
    }

    public static void printCats(List<CsvCat> cats) {
        cats.forEach(System.out::println);
    }
}
