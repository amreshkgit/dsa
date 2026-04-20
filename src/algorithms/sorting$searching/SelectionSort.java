package algorithms.sorting$searching;

public class SelectionSort {
    public static void main(String[] args) {
        int [] A = {6,5,3,4,2,1};
        sort(A,6);
        for (int i=0;i<6;i++){
            System.out.print(" "+A[i]);
        }
    }

    public static void  sort(int [] A , int n){
        for(int i=0;i<n-1;i++){
            int iMin =i;
                for(int j =i+1;j<n;j++){
                    if(A[j] < A[iMin]){
                        iMin = j;
                    }
                int temp =A[i];
                A[i] = A[iMin];
                A[iMin] = temp;
            }
        }
    }
}
