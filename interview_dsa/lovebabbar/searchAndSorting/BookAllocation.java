package lovebabbar.searchAndSorting;

import java.util.Arrays;

public class BookAllocation {
    public static void main(String[] args) {
        int[] pages = {12,34,67,90};
        System.out.println(allocateBook(pages));
    }

    public static int allocateBook(int[] pages){
        int low = pages[0];
        int high = Arrays.stream(pages).sum();
        int res = -1;
        while (low <= high){
            int mid = (low+high)/2;
         if(allocationPossible(mid,pages)){
             res = mid;
             high = mid -1;
         }else{
             low = mid+1;
         }
        }
        return res;
    }

    private static boolean allocationPossible(int barrier,int[] arr) {
        int allocatedStu=1;
        int pages = 0;
        for(int i=0; i<arr.length;i++) {
            if (arr[i] > barrier) {
                return false;
            }
            if (pages + arr[i] > barrier) {
                allocatedStu +=1;
                pages += arr[i];
            }else {
                pages += arr[i];
            }
        }
        if(allocatedStu > 2){
            return false;
        }else return true;
    }
}
