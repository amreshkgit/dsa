package lovebabbar.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningStreamOfInteger {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void insertNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() >=num){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }

        //either both the heaps will have equal number of elements or max heap will have one
        // more element than the min heap
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian(){
        if(maxHeap.size() == minHeap.size()){
            // we have even number of elments, take the avg of middle two elements
            return maxHeap.peek()/2.0 +minHeap.peek()/2.0;
        }
        //because max-heap will have one more element than min-heap
        return maxHeap.peek();

    }

    public static void main(String[] args) {
        MedianOfRunningStreamOfInteger medianOfAStream = new MedianOfRunningStreamOfInteger();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: "+medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: "+medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: "+medianOfAStream.findMedian());
    }
}
