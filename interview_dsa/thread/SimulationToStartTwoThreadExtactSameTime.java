package thread;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;

public class SimulationToStartTwoThreadExtactSameTime {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===============================================");
        System.out.println("        >>> Using CountDownLatch <<<<");
        System.out.println("===============================================");

        CountDownLatch latch = new CountDownLatch(1);

        WorkerWithCountDownLatch worker1 = new WorkerWithCountDownLatch("Worker with latch 1", latch);
        WorkerWithCountDownLatch worker2 = new WorkerWithCountDownLatch("Worker with latch 2", latch);

        worker1.start();
        worker2.start();

        Thread.sleep(10);//simulation of some actual work

        System.out.println("-----------------------------------------------");
        System.out.println(" Now release the latch:");
        System.out.println("-----------------------------------------------");
        latch.countDown();
    }
    }

class WorkerWithCountDownLatch extends Thread {
    private CountDownLatch latch;

    public WorkerWithCountDownLatch(String name, CountDownLatch latch) {
        this.latch = latch;
        setName(name);
    }

    @Override
    public void run() {
        try {
            System.out.printf("[ %s ] created, blocked by the latch...\n", getName());
            latch.await();
            System.out.printf("[ %s ] starts at: %s\n", getName(), Instant.now());
            // do actual work here...
        } catch (InterruptedException e) {
            // handle exception
        }
    }
}