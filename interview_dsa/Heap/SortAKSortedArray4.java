package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortAKSortedArray4 {
    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        System.out.println(sort(arr,6));
    }

    //* Time complexity is nlogk because we are sorting k element at time
    public static List<Integer> sort(int[] a, int k){
        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int e : a){
            minHeap.add(e);
            if(minHeap.size() >k){
                sortedList.add(minHeap.poll());
            }
        }
        //Pop remaining element from min heap
        while(minHeap.size()>0)
        {
            sortedList.add(minHeap.poll());
        }
        return sortedList;
    }
}
