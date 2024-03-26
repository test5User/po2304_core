package lesson30._08_interrupt;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        var thread = new Thread(new MyRnnable());
        thread.start();
        Thread.sleep(5 * 1000);
        thread.interrupt();
    }
}
