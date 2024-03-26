package lesson30._08_interrupt;

public class MyRnnable implements Runnable{
    @Override
    public void run() {
        do{
            if (!Thread.interrupted()) {
                System.out.println("Running");
                try {
                    Thread.sleep(1*1000);
                } catch (InterruptedException e) {
                    return;
                }
            } else {
                return;
            }
        } while (true);
    }
}
