package interviewProgramming;

import java.util.Arrays;

public class FindDuplicateInPlace {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        Arrays.sort(arr);
        removeDuplicate(arr);
       /* HashSet set = new HashSet();
        for(int i=0;i<arr.length;i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }
            else{
                System.out.println(arr[i] +" is duplicate in array");
            }
        }
        System.out.println(set);*/
    }

    static void removeDuplicate(int[] arr){
        int j=0;
        for(int i=0;i<arr.length-1;i++){
           if(arr[i] != arr[i+1]){
               arr[j] = arr[i];
               j++;
           }
           arr[j] = arr[arr.length-1];
        }
        System.out.println(j+1);
        for(int i=0; i<=j;i++){
            System.out.println(arr[i]);
        }
    }
}
