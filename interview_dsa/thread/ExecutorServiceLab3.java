package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceLab3 {
    public static void main(String[] args) {

        //for lot of short lived task
        //newCachedThreadPool creates the synchronous queue to submit the task
        //To also take care to kill the thread will ideal for 60 seconds
        //This will be useful when you don't want to create the no of thread at the beginning
        //And thread will created based on the number task getting submitted to the queue
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            service.execute(new Task2());
        }
    }
}

class Task2 implements Runnable{
    @Override
    public void run() {

    }
}
