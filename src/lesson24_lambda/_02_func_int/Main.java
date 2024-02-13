package lesson24_lambda._02_func_int;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,};
        for (int numb : numbers) {
            if (numb < 5 ) {
                System.out.println(numb);
            } else {
                return;
            }
        }

        var aaa = 15+59;
        OneParamInterface inter = (v1) -> 15 + v1;
    }
}
