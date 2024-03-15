package lesson30._02_creation;

public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Execution in" + Thread.currentThread());
        System.out.println("Hello from Thread");
    }
}
