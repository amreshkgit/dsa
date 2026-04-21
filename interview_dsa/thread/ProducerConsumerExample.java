package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;

public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Shared sharedObject = new Shared();
        CheckNonSync test = new CheckNonSync();
        //CyclicBarrier latch = new CyclicBarrier(3);
        CountDownLatch latch = new CountDownLatch(1);
        Producer1 p = new Producer1(sharedObject,test,latch);
        Consumer1 c = new Consumer1(sharedObject,test,latch);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
        latch.countDown();//This will inform all the threads to start
        //Continue to do whatever
        System.out.println("Thread "+Thread.currentThread().getName() +" started");
    }
}

class Producer1 implements Runnable
{
   private Shared shared;
    CheckNonSync c;
    //CyclicBarrier latch;
    CountDownLatch latch;
    public Producer1(Shared shop,CheckNonSync c,CountDownLatch latch) {
        this.shared = shop;
        this.c =c;
        this.latch = latch;
    }


    @Override
    public void run() {
        /*for(int i =0 ; i< 10; i++){
            System.out.println("Producing the item :: "+i);
            shop.put(i);
        }*/
        System.out.println("Waiting in producer"+latch.getCount());
        try {
            latch.await(); //The thread keeps waiting till it is informed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Object in producer :: "+c+" "+System.currentTimeMillis());
        c.m1();
    }
}


class Consumer1 implements Runnable{
    private Shared shop;
    CheckNonSync c;
   // CyclicBarrier latch;
    CountDownLatch latch;
    public Consumer1(Shared shop, CheckNonSync c,CountDownLatch latch) {
        this.shop = shop;
        this.c = c;
        this.latch = latch;
    }

    @Override
    public void run() {
        /*for (int i =0 ; i < 10; i++){
            int item = shop.get();
            System.out.println("Consumed the item : "+item);
        }*/
        System.out.println("Waiting in consumer"+latch.getCount());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Object in Consumer :: "+c+" "+System.currentTimeMillis());
        c.m2();

       /* try{
            System.out.println("Going to sleep..."+Thread.currentThread().getName());
            Thread.sleep(2000);
        }catch (InterruptedException e){}*/

    }
}

class Shop1{
    private  int material;
    private boolean available = false;

    public synchronized int get(){
       while (!available){
           try {
               wait();
           }catch (InterruptedException e){
               e.printStackTrace();
           }
       }
       available = false;
       notifyAll();
     return material;
    }


    public synchronized void put(int value){
      while (available == true){
          try{
              wait();
          }catch (InterruptedException e){
              e.printStackTrace();
          }
      }
      material = value;
      available = true;
      notifyAll();
    }
}

class CheckNonSync{

    public void m1(){
        System.out.println("Non sync method ; Thread Name  :: "+Thread.currentThread().getName());
    }

    public synchronized void m2(){
        System.out.println("Sync method ; Thread name  ::"+Thread.currentThread().getName());
      /*  try{
            Thread.sleep(20000);
        }catch (InterruptedException e){}*/
    }
}