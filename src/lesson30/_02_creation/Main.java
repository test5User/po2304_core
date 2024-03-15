package lesson30._02_creation;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Creating the new thread from " + Thread.currentThread());
        var myThread = new MyThread("My thread");
        myThread.start();
        myThread.join();
        System.out.println("Leaving from " + Thread.currentThread());
        System.out.println("Creating the new thread from " + Thread.currentThread());
        var myRunnable = new Thread(new MyRunnable(), "My runnable");
        myRunnable.start();
        myRunnable.join();
        System.out.println("Leaving from " + Thread.currentThread());


    }
}
