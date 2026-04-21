package thread;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolExample {
    public static void main(String[] args) {
        //This line will start the thread and all thread will in waiting state since intially there will not
        //be any item in queue
        ThreadPool pool = new ThreadPool(3);
        for (int i = 0; i < 5; i++) {
            Tasks task = new Tasks(i);
            //This line will add task to the queue to run
            pool.execute(task);
        }
    }
}

class ThreadPool {
    private final int nThreads;
    private final PoolWorker[] threads;
    //Thread pool implementation internally uses LinkedBlockingQueue for adding and removing tasks to the queue.
    private final LinkedBlockingQueue queue;

    public ThreadPool(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedBlockingQueue();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
       synchronized (queue) {
           System.out.println("Adding the task to q : "+Thread.currentThread().getName());
            queue.add(task);
            queue.notify();
        }
    }
    private class PoolWorker  extends  Thread {//implements Runnable {
        public void run() {
            Runnable task;

            while (true) {
                synchronized (queue) {
                    //System.out.println("lock acquire by thread : "+Thread.currentThread().getName());
                    while (queue.isEmpty()) {
                       // System.out.println("isEmpty :: "+queue.isEmpty());
                        try {
                           // System.out.println("Going to wait state :"+Thread.currentThread().getName());
                            queue.wait();
                        } catch (InterruptedException e) {
                            //System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    task = (Runnable) queue.poll();
                   // System.out.println("getting task from queue :"+Thread.currentThread().getName()+"\t" +task);
                }

                // If we don't catch RuntimeException,
                // the pool could leak threads
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
}

 class Tasks implements Runnable {

    private int num;

    public Tasks(int n) {
        num = n;
    }

    public void run() {System.out.println("Task " + num + " is running.");
    }
}