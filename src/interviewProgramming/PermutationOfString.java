package interviewProgramming;

public class PermutationOfString {
    public static void main(String[] args) {
        String str = "ABC";
        int len = str.length();
        System.out.println("All the permutations of the string are: ");
        permutation(str, 0, len);
    }

    /**
     * time complexity O(n * n!) i.e time to print only one permutation(n) * no of permutation(n!)
     * @param str
     * @param start
     * @param end
     */
    public static void permutation(String str, int start, int end) {
        //Prints the permutations
        if (start == end - 1)
            System.out.println(str);
        else {
            for (int i = start; i < end; i++) {
                //Swapping the string by fixing a character
                str = swapString(str, start, i);
                //Recursively calling function generatePermutation() for rest of the characters
                permutation(str, start + 1, end);
                //Backtracking and swapping the characters again.
                str = swapString(str, start, i); // to recover the original string
            }
        }
    }

    public static String swapString(String a, int i, int j) {
        char[] b =a.toCharArray();
        char temp = b[i];
        b[i] = b[j];
        b[j] = temp;
        return String.valueOf(b);
    }
}

