package lesson24_lambda._02_var_usage;

public class Main1 {
    public static void main(String[] args) {
        final int n = 70;
        int m = 30;
        Operable operable = () -> {
            //n = 100;
            return n + m;
        };
        //n = 200;
        System.out.println(operable.operate());
    }
}
