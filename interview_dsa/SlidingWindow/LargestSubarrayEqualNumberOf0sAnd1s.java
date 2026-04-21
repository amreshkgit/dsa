package SlidingWindow;

import java.util.HashMap;

/**
 * Time Complexity: O(N) where n is the size of an array.
 *
 * Space Complexity: O(n) as map used
 * arr [0,0,1,0,1,0] used for below explanation
 * At start max = 0 and so index will be -1 and cumulative sum = 0.
 * We move further to get a max of 1. And in our hashmap for reference we put the key 0 -> -1 value.
 * We will check in our key value pair if we have the pair of 1? As at index 0 ->0
 * No there is no pair of 1 we will move forward by adding sum = -1 and -1(at 1st index) = sum = -1+ -1 = -2
 * Move forward and check the index(2) we got 1 that means sum = -2 + 1 = -1.
 * Since we already have -1 in our map, that means there is a subarray and length = 2 (index(2) - index(0))  ,subarray = [0,1]
 * Now moving further & at index 3 we got a gain of 1 as Our cumulative sum is  = -1 + -1 = -2 And if we look at hashmap -2 is already present there is a subarray, length index(3-2) = 1 will not update the length here 1 < 2,
 * At index 4 we have 1 so sum = -2 + 1 = -1 and  -1 is already in the hashmap at index 1 and 0 length from 0 to 4 = index(4 - 0) = 4 another one is index(4 - 3) = 1 max-length = 4
 * Finally, our max-length = 4.
 */
public class LargestSubarrayEqualNumberOf0sAnd1s {
    public static void main(String[] args) {
       int arr[] = {1, 0, 1, 1, 1, 0, 0};
        System.out.println(largestSubArray(arr));
    }

    public static int largestSubArray(int[] arr){

            // write your code here
            int max = 0;

            HashMap< Integer, Integer > map = new HashMap < > ();
            map.put(0, -1); // at the starting we will put -1 for 0

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    sum += -1; //whenever we have 0 = -1
                } else if (arr[i] == 1) {
                    sum += +1; // whenever we have 1 = 1
                }
                if (map.containsKey(sum)) {
                    int idx = map.get(sum);
                    int length = i - idx;
                    if (length > max) {
                        max = length;
                    }
                } else {
                    map.put(sum, i);
                }
            }
           return max;
    }
}
