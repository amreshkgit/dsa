package lovebabbar.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given an array of intervals, merge all the overlapping intervals and
// return an array of non-overlapping intervals.
//Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
//Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that,
// we are just using a single loop that runs for N times. So, the time complexity will be O(N).
//
//Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {8, 9}, {9, 11}, {15, 18}, {2, 4}, {16, 17}};
        int[][] shiftTiming = {{8, 10}, {10, 12}, {14, 19}};
        int[][] result = merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //Store first a pair of interval as start and end
        int start = intervals[0][0];
        int end = intervals[0][1];
        //linearly iterate to the sorted array
        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}


