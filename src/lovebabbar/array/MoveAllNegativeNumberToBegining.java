package lovebabbar.array;

/**
 * Time complexity: O(N)
 * Auxiliary Space: O(1)
 */
public class MoveAllNegativeNumberToBegining {
    public static void main(String[] args) {
        int[] a={-12, 11, -13, -5, 6, -7, 5, -3, -6};
        move(a);
        for(int x:a){
            System.out.print(x+" ");
        }
    }

    public static void move(int[] a){
        int start = 0;
        int end = a.length-1;
       while(start <= end){
            if(a[start] <= 0){
                start++;
            }
            else {
                swap(a, start, end--);
            }
        }
    }

        private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
