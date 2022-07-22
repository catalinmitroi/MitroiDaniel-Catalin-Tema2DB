import java.util.concurrent.Semaphore;

class Resource{
    static int count = 0;
}
public class MyThread extends Thread {
    Semaphore semaphore;
    String threadName;

    public MyThread(Semaphore semaphore, String threadName) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
    }
    @Override
    public void run() {
        if (this.getName().equals("North-South traffic light")) {
            try {
                semaphore.acquire();
                System.out.println(threadName + " turned on.");

                for (int i = 0; i < 3; i++) {
                    Resource.count++;
                    System.out.println(threadName + ": " + "CAR " + Resource.count);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        else {
            try {
                semaphore.acquire();
                System.out.println(threadName + " turned on.");

                for (int  i = 3; i < 6; i++) {
                    Resource.count++;
                    System.out.println(threadName + ": " + "CAR " + Resource.count);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(threadName + "  turned off.");
        semaphore.release();

    }
}
