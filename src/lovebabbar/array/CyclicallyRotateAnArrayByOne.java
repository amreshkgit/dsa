package lovebabbar.array;

import java.util.Arrays;

public class CyclicallyRotateAnArrayByOne {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5,6,7};
        int k = 1; // use give any number of rotation like 2, 3 or so on
        rotate(A,k);
        System.out.println(Arrays.toString(A));
    }

    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k = k%n;
        System.out.println("K: "+k);
        reverseArray(nums,0,n-1); // reverse entire array 7 6 5 4 3 2 1
        reverseArray(nums,0,k-1); // rotate k element from starting till kth element Here rotate ele 7 6 5
        reverseArray(nums,k,n-1); // rotate remaining element 4 3 2 1
    }

    private static void reverseArray(int[] nums, int start, int end) {
        for(int i=start,j=end;i<j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
