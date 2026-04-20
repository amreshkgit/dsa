package Heap;

import java.util.*;

// Problem to find the top k frequent element in the array
public class TopKFrequentNumbers6 {
    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3,3,3,4};
        System.out.println(Arrays.toString(topKFrequentNumbers(a, 2)));
    }

    // First create a map to store the frequency of the element
    // Then traverse on the frequency and keep adding to the heap
    //Meaning traverse the map and keep adding the element on the basis of frequency
    static int[] topKFrequentNumbers(int[] arr,int k){
        int res[] = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int e : arr){
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));

        //Traverse on the map
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            minHeap.add(entry.getKey());
        }
        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll();
        }
        return res;

    }
}
