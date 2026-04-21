package com.interview.array;

import java.util.Arrays;

public class MoveAllZerosToEnd {

    public void moveZeros(int arr[]){
        int slow =0;
        int fast =0;
        while(fast < arr.length){
            if(arr[fast] == 0){
                fast++;
                continue;
            }
            arr[slow] = arr[fast];
            slow++;
            fast++;
        }
        while(slow < arr.length){
            arr[slow++] = 0;
        }
        Arrays.toString(arr);
    }
    
    public static void main(String args[]){
        MoveAllZerosToEnd maz  = new MoveAllZerosToEnd();
        int arr[] = {0,1,0,3,12};
        maz.moveZeros(arr);
        //System.out.println(Arrays.toString(arr));
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
