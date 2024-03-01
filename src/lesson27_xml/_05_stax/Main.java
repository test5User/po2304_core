package lesson27_xml._05_stax;

public class Main {
    public static void main(String[] args) {
        StaxParser.parseXml().forEach(System.out::println);
    }
}
