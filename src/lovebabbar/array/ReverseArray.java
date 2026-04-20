package lovebabbar.array;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5};
        reverse(a,a.length);
    }

    public static void reverse(int[] a,int x){
        if(x == 0){
            return;
        }
        System.out.println(a[x-1]+" ");
        reverse(a,x-1);
    }
}
