import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore sem = new Semaphore(1);

        MyThread NS = new MyThread(sem, "North-South traffic light");
        MyThread WE = new MyThread(sem, "West-East traffic light");

        NS.start();
        WE.start();

        NS.join();
        WE.join();

    }

}