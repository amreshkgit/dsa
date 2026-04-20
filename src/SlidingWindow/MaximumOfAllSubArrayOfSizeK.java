package SlidingWindow;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumOfAllSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr ={1,3,-1,-3,8,3,6,7};
        System.out.println(findTheMaximum(arr,3).poll());
    }

    public static PriorityQueue<Integer> findTheMaximum(int[] arr, int size){
        int i =0; int j=0;
        int max = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());//max heap
        while ( j < arr.length){
            if(arr[j] > max ){
                max = arr[j];
            }
            if(j-i+1 < size)
                j++;
            else if(j-i+1 == size){
                if(!maxHeap.contains(max))
                    maxHeap.add(max);
                i++;
                j++;
            }
        }
        return maxHeap;
    }
}
