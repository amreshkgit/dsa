package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceLab1 {
    public static void main(String[] args) {
        //Create the thread pool
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Available core count ::"+coreCount);

        //you have some fix number of thread based on the cpu core size
        ExecutorService cpuIntensiveService = Executors.newFixedThreadPool(4);

        //you can have many number of threads
        ExecutorService IOIntensiveService = Executors.newFixedThreadPool(100);

        //Submit the task for execution and internally maintains th e blocking queue to handle
        // the concurrent operation and this queue is thread safe and that is why thread pool uses the
        // blocking queue
        //Ideal pool size?
        //1. when you have cpu intensive job like algorithm of hashing/or cryptographic function then use the no
        // of thread as no of core in the CPU
        //2. When you have IO intensive operation means your task gets the data from database or call http url and gets the data from
        //their. Here what happens is once those request made to the database or http client it will wait for Operating system to get
        // a response and all thread will go to waiting state. So, even though we have 4 core cpu there is no point of having only
        //few threads because most of the might be waiting for operation to finished and  no thread will available to fetch the
        // Next task and execute it.
        // and then you have ideal pool should be large one because threads will waiting from operating system to get the data.

        //Below execute method thread will do the two task , first it will fetch the task from queue and execute it
        for(int i=0;i<4;i++){
            cpuIntensiveService.execute(new CpuIntensiveTask());
        }

        for(int i=0;i<4;i++){
            IOIntensiveService.execute(new IOIntensiveTask());
        }
       // System.out.println(Thread.currentThread().getName());

        /*for(int i=0 ;i<5 ;i++){
            CompletableFuture.supplyAsync(()->getOrder())
                    .thenApply(order -> enrich(order))
                    .thenApply(order -> performPayment(order))
                    .thenApply(order -> dispatch(order))
                    .thenApply(order -> sendEmail(order));
        }*/
    }

}

class CpuIntensiveTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Executing the task 1");
        System.out.println(Thread.currentThread().getName());
    }
}

class IOIntensiveTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Executing the task 1");
        System.out.println(Thread.currentThread().getName());
    }
}