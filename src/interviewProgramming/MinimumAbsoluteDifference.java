package interviewProgramming;

import java.util.Arrays;
import java.util.HashMap;

//absolute difference means |-7-0| = 7
//In absolute difference we don't consider the negative , every difference is consider as
//positive difference even though difference is negative
public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        int[] arr ={1,-7,0,9};
        System.out.println(minimumAbsoluteDifference(arr));
        int max = maximumAbsoluteDifference(arr,map);
        System.out.println(max);
        String max_absolute_pair = map.get(max);
        System.out.println("Max absolute pair "+max_absolute_pair);
    }

    static int minimumAbsoluteDifference(int[] arr){
        int min_absolute_difference = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for(int i=0;i<arr.length -1 ;i++){
            int cur_absolute_difference = Math.abs(arr[i]-arr[i+1]);
            min_absolute_difference = Math.min(cur_absolute_difference,min_absolute_difference);
        }
        return min_absolute_difference;
    }

    static int maximumAbsoluteDifference(int[] arr,HashMap map){
        int max_absolute_difference = Integer.MIN_VALUE;

        Arrays.sort(arr);
        for(int i=0;i<arr.length -1 ;i++){
            int cur_absolute_difference = Math.abs(arr[i]-arr[i+1]);
            max_absolute_difference = Math.max(cur_absolute_difference,max_absolute_difference);
            if(cur_absolute_difference >= max_absolute_difference)
            map.put(cur_absolute_difference,"("+arr[i]+","+arr[i+1]+")");
        }
        return max_absolute_difference;
    }
}
