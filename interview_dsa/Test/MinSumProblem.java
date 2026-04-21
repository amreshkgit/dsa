package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumProblem {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(7);
        list.add(20);
        list.add(10);
        int [] arr={7,20,10,40};
        Arrays.sort(arr);
        int k=4, sum=0;
        int[] res = minSum(arr,0,k,arr.length,0,arr.length-k);
        for (int j = 0; j < res.length; j++) {
            sum = sum + arr[j];
        }
        System.out.println(sum);
    }

    public static int[] minSum(int[]arr,int num1,int k,int size,int minSum,int diff ) {

        if (k == 0 || size == 0) {
            return null;
        }
        double num = arr[size - 1];
        num = num / 2;
        num = Math.ceil(Double.valueOf(num));
        arr[size - 1] = (int) num;
        minSum(arr, arr[size - 1], k - 1, size - 1,minSum,diff);
        if(diff ==1 && size ==1){
            double numm = arr[arr.length-1];
            numm = numm / 2;
            numm = Math.ceil(Double.valueOf(numm));
            arr[arr.length-1] = (int) numm;
        }
        return arr;

    }

}
