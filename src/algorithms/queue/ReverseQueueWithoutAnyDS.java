package algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueWithoutAnyDS {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        queue.add(56);
        queue.add(27);
        queue.add(30);
        //queue.add(45);
        //queue.add(85);
       // queue.add(92);
        //queue.add(58);
        //queue.add(80);
        //queue.add(90);
        //queue.add(100);
        System.out.println(queue);
        queue = reverseQueue(queue);
        Print(queue);
    }

    static Queue<Integer> reverseQueue(Queue<Integer> q)
    {
        // Base case
        if (q.isEmpty())
            return q;

        // Dequeue current item (from front)
        int data = q.peek();
        q.remove();

        // Reverse remaining queue
        q = reverseQueue(q);

        // Enqueue current item (to rear)
        q.add(data);

        return q;
    }

    static void Print(Queue queue)
    {
        while (!queue.isEmpty())
        {
            System.out.print(queue.peek() + " ");
            queue.remove();
        }
    }
}
