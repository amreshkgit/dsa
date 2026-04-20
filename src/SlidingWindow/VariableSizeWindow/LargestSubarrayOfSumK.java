package SlidingWindow.VariableSizeWindow;


public class LargestSubarrayOfSumK {
    public static void main(String[] args) {
        int[] arr={4,1,1,1,2,3,5};
        System.out.println(largestSubarraySum(arr,5));
    }

    public static int largestSubarraySum(int[] arr,int k){
        int i=0, j=0;
        int sum =0, max=0;
        while (j< arr.length){

            sum = sum + arr[j];

            //1. First condition
            if(sum < k){
                j++; // humko sum ke taraf jana hai kyun ki abhi sum less then k hai
            }

            //2. second condition
            if (sum == k) {
                max = Math.max(max,j-i+1); // j-i+1 window size
                j++;
               /* sum  = sum + arr[j];
                j++; // ek canddidate mil gaya hai, aur age aur candidate search karna hai to aage jane k liye j++
                sum = sum-arr[i];
                i++;*/
            }

            //2. third condition when sum > k
            if( sum > k){
                while (sum > k){
                    sum = sum-arr[i];
                    i++;
                    if(sum == k){
                        max = Math.max(max, j - i + 1);
                    }
                }
                j++;
            }
        }

        return max;
    }
}
