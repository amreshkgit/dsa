package lovebabbar.array;

/**
 * The number of all possible subarrays of an array of size N is N* (N+1)/2
 * N = 4 , subarray is 10
 * N = 5, subarray is 15
 * Best optimize solution using kadaen's algo which has time complexity as O(n)
 * Time complexity - O(n)
 */
public class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        int [] a= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(largestSum(a));
    }

    public static int largestSum(int[] a) {
        int bestSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i =0; i<a.length;i++){
            currentSum = Math.max(a[i],currentSum+a[i]); //[-2 1] = (1, -2 + 1) => (1,-1) => max of both is 1
            bestSum = Math.max(bestSum,currentSum);
        }
        return bestSum;
    }
}
