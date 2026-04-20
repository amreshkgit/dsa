package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Tick to solve the problem
 *  create a maxheap of pair type and keep adding pair object which will keep key and data
 *  here key will be difference between array current number and input number to find closet to it
 *  during course of array traversal.
 *
 *  onece travsersal is over poll remaining element from heap and print
 *
 */
public class KClosestNumber5 {
    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9, 10 };
        kClose(arr, 3, 7); // find 3 number closet to 7
    }

    //Sorting will be done on key and key will absolut difference b/w number and x see line number 16
    static void kClose(int arr[], int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            maxHeap.add(new Pair(Math.abs(i - x), i)); // array number minus X
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        while (maxHeap.size() > 0) {
            System.out.print(maxHeap.poll().data + " ");
        }
    }

}