package DynamicProgramming;

public class longestPalindromeSubStringdp {
    public static int longestPalindrome(String s) {
        // Corner cases.
        if (s.length() <= 1) return s.length();

        int len = s.length(), longestPalindromeStart = 0, longestPalindromeLength = 1;
        // state[i][j] true if s[i, j] is palindrome.
        boolean[][] state = new boolean[len][len];

        // Base cases.
        for (int i = 0; i < len; i++) {
            //filling diagonal cell first which representing single element (0,0)(,1,1)(2,2)(3,3)...
            // single element is always a plaindrome
            state[i][i] = true; // dist = 0.
        }


        for (int i = len - 1; i >= 0; i--) {
            for (int dist = 1; dist < len - i; dist++) {
                int j = dist + i;
                //(s.charAt(i) == s.charAt(j)) is refering a ... a
                //state[i + 1][j - 1] to check non boundary string abcba here considering non boundary is bcb
                state[i][j] = (dist == 1) ? s.charAt(i) == s.charAt(j) : (s.charAt(i) == s.charAt(j)) && state[i + 1][j - 1];
                if (state[i][j] && j - i + 1 > longestPalindromeLength) {
                    longestPalindromeLength = j - i + 1;
                    longestPalindromeStart = i;
                }
            }
        }

        return longestPalindromeLength;
    }


    public static void main(String args[]) {
        // Your code goes here
        String s = "Hello";
        System.out.println(longestPalindrome(s));
    }

}
