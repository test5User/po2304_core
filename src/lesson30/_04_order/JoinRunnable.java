package lesson30._04_order;

import lombok.SneakyThrows;

public class JoinRunnable extends Thread {
    public JoinRunnable(String name) {
        super(name);
    }

    @SneakyThrows
    @Override
    public void run() {
        var currentThreadName = Thread.currentThread().getName();
        for (var i = 0; i < 10; i++) {
            System.out.println(currentThreadName + " is running" + i);
            //Thread.sleep(1000);
            Thread.yield();
        }
        System.out.println(currentThreadName + " completed");
    }
}
