package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(5);
        for(int i=0;i<5;i++){
            System.out.println("adding item");
            blockingQueue.put(i);
        }
        for (int j=0; j<5;j++){
            int i = (int)blockingQueue.take();
            System.out.println("taking item" +i);
        }

    }
}

class BlockingQueue<E> {
    int max;
    private Queue<E> queue;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    private Object notEmpty1 = new Object();
    private Object notFull1 = new Object();

    public BlockingQueue(int size) {
        queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E o) {
        lock.lock(); //acquiring the lock
        try {
            while (queue.size() == max) {
                //if (queue.size() == max) {
                notFull.await();//block the thread if queue size is full and waiting for this condition i.e. notFull to be satisfied
            }
            queue.add(o);
            notEmpty.signalAll(); //Signaling consumer thread the i have added item to the queue means all the thread who is waiting for
            // on this condition.Here who is waiting on this condition is consumer thread
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock(); //releasing the lock
        }
    }

    public Object take() {
        Object o = null;
        lock.lock(); //acquiring the lock
        try {
            // replace if with while because when two thread will try to access
            // at the same time then one thread will remove the item from the queue
            // and when second thread will try to remove item from the queue then it will get null
            // in order to avoid we need to replace with while so, that thread will recheck the q size
            while (queue.size() == 0) {
                notEmpty.await();//Here someone say is queue is not empty so that i can processed to take an item
                // block the thread if queue size is zero
            }
            o = queue.remove();
            notFull.signalAll(); //notFull.notifyAll();
            //return o;
        } catch (Exception e) {
        } finally {
            lock.unlock(); //releasing the lock this lock is of reentrantLock type
        }
        return o;
    }

    /*public synchronized Object take1() {
        Object o = null;
        try {
            if (queue.size() == 0) {
                notEmpty.wait();//Here someone say is queue is not empty so that i can processed to take an item
                // block the thread if queue size is zero
            }
            o = queue.remove();
            notFull.signalAll();
            return o;
        } catch (Exception e) {

        }
        return o;
    }
*/
    public synchronized void put1(E e) throws InterruptedException {
        while (queue.size() == max) {
            //wait for this condition to be true, someone say that q is not full
            notFull1.wait();
        }
        queue.add(e);
        notEmpty1.notifyAll();
    }

    public synchronized E take1() throws InterruptedException {
        while (queue.size() == 0) {
            notEmpty1.wait();
        }
        E item = queue.remove();
        notFull1.notifyAll();
        return item;
    }
}
