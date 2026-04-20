package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceLab2 {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        //task to run after 10 second delay

        service.schedule(new Task1(),10, TimeUnit.SECONDS);
        //task to repeatedly after 10 seconds

        service.scheduleAtFixedRate(new Task1(),10,10,TimeUnit.SECONDS);
        //task to run repeatedly 10 seconds after previous task completes
        service.scheduleWithFixedDelay(new Task1(),15,10,TimeUnit.SECONDS);
    }
}

class Task1 implements Runnable{
    @Override
    public void run() {
        //task that need to run based on schedule
    }
}
