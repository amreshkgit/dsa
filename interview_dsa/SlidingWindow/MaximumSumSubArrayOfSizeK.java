package SlidingWindow;

/**
 * Find the maximum sum of subarray of size k
 */
public class MaximumSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int [] arr ={2,5,1,8,2,9,1};
        int [] arr1 ={100, 200 ,300,400};
        System.out.println(findMaximumSum(arr1,2));
    }

    static int findMaximumSum(int[]arr,int wSize){
        int i=0, j=0; // i is start and j is end
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (j < arr.length)
        {
            //calculation karenge
            sum = sum + arr[j];
            //Jab tak window size hit nahi hai, humlog koi calculation nahi kar rahe hai , sirf j ko increase karenge
            if(j-i+1 < wSize) {
                j++;
            }
            else if(j-i+1 == wSize){
                max=Math.max(max, sum);
                sum = sum-arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
}
