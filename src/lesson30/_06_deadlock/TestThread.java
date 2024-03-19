package lesson30._06_deadlock;

import lombok.SneakyThrows;

public class TestThread {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        var t1 = new ThreadDemo1();
        var t2 = new ThreadDemo2();
        t1.start();
        t2.start();
    }

    private static class ThreadDemo1 extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                Thread.sleep(10);
                System.out.println("Thread 1: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }

    private static class ThreadDemo2 extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2: Holding lock2...");
                Thread.sleep(10);
                System.out.println("Thread 2: Waiting for lock1...");
                synchronized (lock2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}
