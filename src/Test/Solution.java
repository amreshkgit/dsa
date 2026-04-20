package Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(7);
        list.add(10);
        list.add(20);
        int sum = minSum(list,4);
        System.out.println(sum);

    }


    public static int minSum(List<Integer> num, int k) {
        double minSum =0;
        double [] arr = new double[num.size()];
        if(k ==1){
            double number = num.get(0);
            number = number/2;
            number = Math.ceil(number);
            return (int) number;
        }
        else {
               k = k+1;
                for (int i = 0; i < num.size(); i++) {
                    double number = num.get(i);
                    number = number / 2;
                    number = Math.ceil(number);
                    arr[i] = number;
                    k--;
                }
            if(k!=0){
                double max = arr[0];
                int pointer =0;
                for (int i= 0;i<arr.length;i++){
                    if (arr[i] > max)
                        max = arr[i];
                    pointer = i;
                }
                double number = max;
                number = number / 2;
                number = Math.ceil(number);
                arr[pointer] = number;

            }
            for(int i=0;i<arr.length;i++){
                    minSum = minSum + arr[i];
                }

        }
        return (int) minSum;

    }

}
