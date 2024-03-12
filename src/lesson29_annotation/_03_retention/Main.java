package lesson29_annotation._03_retention;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var annClassObj = new AnnotatedClass();
        //var annClassObj = AnnotatedClass.class;
        var annotations = annClassObj.getClass().getAnnotations();
        System.out.println("Quantity RunTime annotations " + annotations.length);
        Arrays.stream(annotations).forEach(System.out::println);
    }
}
