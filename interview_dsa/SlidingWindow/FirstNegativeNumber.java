package SlidingWindow;

import java.util.*;

/**
 * First negative number in every window of size k
 */
public class FirstNegativeNumber {
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        System.out.println(Arrays.toString(firstNegativeNumber(arr, 3)));
    }
     static long[] firstNegativeNumber(int[]arr,int k){
        int i=0,j=0;
        Queue<Integer> queue = new LinkedList<>();
        int n = arr.length;
        long[] result = new long[n-k+1];
        int idx=0;

        while (j<arr.length){

            //keep adding element when is negative
            if(arr[j] < 0){
                queue.add(arr[j]);
            }

            if(j-i+1==k){
                //when we hit the window and queue size is zero that means no negative element was persent in that window
                if (queue.size() == 0){
                    result[idx++] = 0;
                }else{
                    //Otherwise get the element from head of the queue
                    result[idx++] = queue.peek();
                    //now before sliding the window check if element is percent in the queue then remove
                    if(arr[i] == queue.peek())
                        queue.poll();
                }
                i++;
            }
            j++;
        }
        return result;
     }
}
