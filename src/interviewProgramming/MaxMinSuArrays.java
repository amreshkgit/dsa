package interviewProgramming;

public class MaxMinSuArrays {
     static int min=0;
    public static void main(String[] args) {

        int m =2;
        int[] arr ={1,2,3,1,2};
        int start=0,end=0;
        int m1 = maxMinInSubArray(arr,start,end);
        System.out.println(m1);
    }

    static int maxMinInSubArray(int[] arr,int start , int end) {
        if (start < end) {
             min = Math.min(maxMinInSubArray(arr, start, end + 1), maxMinInSubArray(arr, end, start + 1));
        }
        return min;
    }
}


