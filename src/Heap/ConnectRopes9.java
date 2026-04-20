package Heap;

import java.util.PriorityQueue;

/**
 * Connect Ropes to Minimise the Cost
 *
 * We will give a integer number and number represent the length of the ropes
 * we have add ropes in such a way so that cost will be minimum
 *
 * Trick to solve the problem
 * Any time take two minimum ropes and add it will produce a minimum cost
 */
public class ConnectRopes9 {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        System.out.println(connectRopes(arr));

    }

    //Minimize the cost while connecting the rope
    static int connectRopes(int [] arr){
        int tcost = 0;
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        //Step 1 add array element to min heap
        for(int i =0 ;i<arr.length;i++){
            minHeap.add(arr[i]);
        }

        //Traverse min heap until size > 0
        while(minHeap.size() != 1)
        {
            //Get the first element
            int first = minHeap.poll();
            //get the second element
            int second = minHeap.poll();
            //get the rop len
            int newRopeLen = first+second;
            tcost = tcost + newRopeLen;
            //add new rop len to min heap
            minHeap.add(newRopeLen);
        }
        return tcost;
    }
}
