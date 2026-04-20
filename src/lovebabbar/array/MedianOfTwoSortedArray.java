package lovebabbar.array;

/**
 * How to solve the problem
 * 1. Apply binary search on smaller array -it will give cut1
 * 2. find cut2 N/2 -> (n1+n2)/2-cut1 n1 and n2 is length of two given array
 * 3. validate cut if l1<=r2 && l2 <==r1
 *   if invalid cut
 *   l1>r2 end = cut1-1
 *   else start = cut1+1
 * 4. if cut become valid
 *   odd
 *    return Math.min(r1, r2);
 *   even
 *    return (Math.max(l1, l2) + Math.max(r1, r2) / 2.0);
 *
 */
public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
      /* int arr1[] = {-5, 3, 6, 12, 15};
       int arr2[] = {-12, -10, -6, -3, 4, 10};*/
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };
       /* int arr1[] = {}; int arr2[] = {2, 4, 5, 6};*/
       System.out.println(findMedianSortedArray(arr1,arr2));
    }

    public static double findMedianSortedArray(int[] nums1, int nums2[]) {
        //make nums1 as min length array
        //call same function , and change the params
        // if nums1 was greater and nums2 was smaller
        // because we swapped these two , now nums1 is smaller and nums2 greater
        //when length are different than apply binary search on shortest array to avoid index out of bound
        if (nums1.length > nums2.length) {
            return findMedianSortedArray(nums1, nums2);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int start = 0;
        int end = n1;
        int N = (n1 + n2) / 2;

        while (start <= end) {
            //mid --> cut1
            int cut1 = start + (end - start) / 2;
            int cut2 = N - cut1;
            // l1, l2, r1, r2 find
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1]; // when binary search cross the start dats y taking MIN_VALUE
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            //check if cut is valid
            if (l1 <= r2 && l2 <= r1) {
                //if N is odd
                if (N % 2 != 0) {
                    return Math.min(r1, r2);
                } else {
                    // if N is even, there will two median
                    return ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
                }
            } else if (l1 > r2) {
                end = cut1 - 1;
            } else {
                start = cut1 + 1;
            }

        }
    return 0.0;
    }
}
