package lovebabbar.array;

public class FindMaxAndMinElementInArray {
    public static void main(String[] args) {
        int[]a={10,3,80,40,12,60};
        findMinAndMax(a);
    }

    public static void findMinAndMax(int[] arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        System.out.println("Maximum element is "+max);
        System.out.println("Minimum element is "+min);
    }
}
