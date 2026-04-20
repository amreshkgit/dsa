package lovebabbar.searchAndSorting;

public class InversionCount {
    public static void main(String[] args) {
    long[] arr = {2, 4, 1, 3, 5};
        System.out.println(mergeSort(arr,0,4));
    }

    public static long mergeSort(long[] arr,int s, int f){
        long counter=0;
        if(s<f){
            int mid = s+(f-s)/2;
            counter+=mergeSort(arr,s,mid); // left half
            counter+=mergeSort(arr,mid+1,f); // right half
            counter+= merge(arr,s,mid,f);
        }
        return counter;
    }

    private static long merge(long[] arr, int s, int mid, int f) {
        long counter=0;
        int n1=(mid-s+1);
        int n2=(f-mid);
        long[] left = new long[n1];
        long[] right = new long[n2];

        for (int i = 0; i <n1; i++) {
            left[i] = arr[s + i];
        }

        /*Copy data to temp arrays*/
        for (int j = 0; j <n2; j++) {
            right[j] = arr[mid + 1 + j];
        }
        int i=0,j=0,k=s;
        while(i<n1 && j<n2){
            if(left[i] <=right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                counter+=n1-i;
                j++;
            }
            k++;
        }
        while (i<n1){
            arr[k++]=left[i++];
        }
        while (j<n2){
            arr[k++]=right[j++];
        }
        return counter;
    }
}
