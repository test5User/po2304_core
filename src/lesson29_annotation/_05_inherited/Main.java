package lesson29_annotation._05_inherited;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var parentAnnotations = Parent.class.getAnnotations();
        var childAnnotations = Child.class.getAnnotations();

        System.out.println("Parent's annotations " + parentAnnotations.length);
        Arrays.stream(parentAnnotations).forEach(System.out::println);
        System.out.println("Child's annotations " + childAnnotations.length);
        Arrays.stream(childAnnotations).forEach(System.out::println);
    }
}
