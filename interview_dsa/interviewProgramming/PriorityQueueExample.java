package interviewProgramming;

/**
 * O(log n) time for the enqueing and dequeing methods (offer, poll, remove() and add)
 *
 * O(n) for the remove(Object) and contains(Object) methods
 *
 * O(1) for the retrieval methods (peek, element, and size)
 */
public class PriorityQueueExample {
    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue(10); // Priority Queue holds 10 elements

        priorityQueue.insert(81);
        priorityQueue.insert(72);
        priorityQueue.insert(91);
        priorityQueue.insert(61);

        System.out.print("Deleted elements from queue: ");
        System.out.print(priorityQueue.remove() + " ");
       // System.out.print(priorityQueue.remove() + " ");
       // System.out.print(priorityQueue.remove() + " ");
       // System.out.print(priorityQueue.remove() + " ");

    }
}


class PriorityQueue {
    private int[] prioQueueAr;
    private int size;//Size of Queue
    private int number;  //holds number of elements in Priority Queue, initialized with 0 by default

    public PriorityQueue(int size){
        this.size = size;
        prioQueueAr = new int[size];
        number = 0;
    }


    /**
     * Insert element in Priority Queue, element will be inserted on basis of priority.
     */
    public void insert(int value) throws Exception {
        int i;
        if(isFull()){
            throw new Exception("Cannot insert "+value+", Queue is full");
        }
        if (number == 0)
            prioQueueAr[number++] = value; //If no values in PriorityQueue- insert at starting position, i.e. at 0th position.
        else{
            for (i = number - 1; i >= 0; i--){
                if (value > prioQueueAr[i])
                    prioQueueAr[i + 1] = prioQueueAr[i]; //if value is larger, shift elements upward till value is larger.
                else
                    break;
            }
            prioQueueAr[++i] = value; // insert element in space created by upward shift of elements.
            number++;
        }
    }


    /**
     * Remove elements from Priority Queue
     */
    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return prioQueueAr[--number];
    }

    /**
     * Returns true if Priority Queue is full
     * @return
     */
    public boolean isFull(){
        return (number == size);
    }

    /**
     * Returns true if Priority Queue is empty
     * @return
     */
    public boolean isEmpty(){
        return (number == 0);
    }

}
