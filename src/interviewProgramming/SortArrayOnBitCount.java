package interviewProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayOnBitCount {
    public static void main(String[] args) {
        Integer arr[] = {3,1,2};
        int n = arr.length;
        sortBySetBitCount(arr, n);
        printArr(arr, n);
        System.out.println();
    }
    private static void printArr(Integer[] arr, int n)
    {
        // TODO Auto-generated method stub
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            //System.out.print(Integer.toBinaryString(arr[i]) + " ");
        }

    }
    private static Integer[] sortBySetBitCount(Integer[] arr, int n)
    {
        // TODO Auto-generated method stub
        Arrays.sort(arr, new Comparator<Integer>()
        {

            @Override
            public int compare(Integer arg0, Integer arg1)
            {
                // TODO Auto-generated method stub
                int c1 = Integer.bitCount(arg0);
                int c2 = Integer.bitCount(arg1);
                if (c1 >= c2)
                    return 1;
                else
                    return -1;
            }

        });
        return arr;
    }
}

