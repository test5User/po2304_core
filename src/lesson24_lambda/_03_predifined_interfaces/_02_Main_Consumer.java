package lesson24_lambda._03_predifined_interfaces;

import java.util.function.Consumer;

public class _02_Main_Consumer {
    public static void main(String[] args) {
        //T -> void;
        Consumer<String> toUpperCase = System.out::println;
        Consumer<String> toLowerCase = str -> System.out.println(str.toLowerCase());
        //toUpperCase.accept("hello!!!");
        toUpperCase.andThen(toLowerCase).accept("Hello World");
    }
}
