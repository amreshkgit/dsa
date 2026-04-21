package lovebabbar.array;

/**
 * We will take two auxiliary array with same input size.
 * First array will call as left which will store the element while processing
 * array from left and right array will store element while processing array from right.
 * Int array[]={3,2,1,4,0,1,3,2]
 * Get any element greater than 3 on left of 3 here nothing therefore it will be 3.
 * Next compare 3 with 2 then it will 3 then compare 3 with 1 then it will 3 then compare
 * 3 with 4 then it will 4 and soon.
 * Left array= 3,3,3,4,4,4,4,4
 * Right array=4,4,4,4,3,3,3,2
 * Formula to get trapping water
 * I=Math.min(left[I],right[I]) - height[I];
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int [] a={3,2,1,4,0,1,3,2};
        System.out.println(trappingRainWater(a));
    }

    public static int trappingRainWater(int[] buildingHeight) {
        int n = buildingHeight.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = buildingHeight[0]; // to store first element in the left array to compare
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], buildingHeight[i]);
        }
        right[n-1]=buildingHeight[n-1]; // to store last element in the right array to compare
        for (int i = n-2; i >=0; i--) {
            right[i] = Math.max(right[i + 1], buildingHeight[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=(Math.min(left[i],right[i])-buildingHeight[i]);
        }
        return ans;
    }
}
