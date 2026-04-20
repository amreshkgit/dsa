package Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * O(log n) time for the enqueing and dequeing methods (offer, poll, remove() and add)
 *
 * O(n) for the remove(Object) and contains(Object) methods
 *
 * O(1) for the retrieval methods (peek, element, and size)
 */
public class FrequencySort7 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 2, 2, 2, 4};
        frequencySort(arr);
    }

    static void frequencySort(int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();

        //Key is frequency and value as element
        for (int e : ar) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new Pair(entry.getValue(), entry.getKey())); // frequency -> data
        }

        while (maxHeap.size() > 0) {
            int freq = maxHeap.peek().key;
            int data = maxHeap.peek().data;
            for (int i = 0; i < freq; i++) {
                System.out.print(data + " ");
            }
            maxHeap.poll();
        }
    }
}
