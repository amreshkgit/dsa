package SlidingWindow.VariableSizeWindow;

public class MinimumSubArraySumGreaterThanK {
    public static void main(String[] args) {

    }

        public int minSubArray(int[] a, int target){
        int n = a.length;
        int sum =0;
        int left =0;
        int right =0;
        int shortest = Integer.MAX_VALUE;
        //keep running untile right goes out of bound.
            while(right < n){
                sum+= a[right];
                if(sum >= target){
                    //skip all left element till sum < target (to find the smallest window)
                    //Nothing but compressing from the left side
                    while (sum >=target){
                        sum -= a[left];
                        left++;
                    }
                    shortest = Math.min(shortest,right-left+2); // update smallest window size
                    //here (r-l+1)+1 here extra +1 is to include the previous element ideal window size is r-l+1
                }
                right++;
            }
            return shortest == Integer.MAX_VALUE ? 0 : shortest;
        }
}
