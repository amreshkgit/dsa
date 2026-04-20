package Heap;

import java.util.*;

/**
 * When you want find the Kth smallest element then we need to use max heap
 *
 * when you want find the Kth largest element the need to use the min heap
 */
public class KthSmallestAndLargest2And3 {
    public static void main(String[] args) {
        //String str = "Houston we have a problem";
        String str ="It is the hottest sun in the beach";
        int[] arr = {7, 4, 3, 10, 20, 8};
        int thirdSmallest = kthSmallestElement(arr, 3);
        System.out.println(thirdSmallest);
        int thirdLargest = kthLargestElement(arr, 2);
        System.out.println(thirdLargest);
     }

    public static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int value : arr) {
            maxHeap.add(value);
            if (maxHeap.size() > k) {
                maxHeap.poll(); //remove the element from the top
            }
        }
        Integer max = maxHeap.peek(); //retrieve the element from the top
        return max;
    }

    public static Integer kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int value : arr) {
            minHeap.add(value);
            if (minHeap.size() > k) {
                minHeap.poll(); //remove the element from the top
            }
        }
        return minHeap.peek(); //retrieve the element from the top
    }


}
