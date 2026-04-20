package DynamicProgramming;

public class LongestPalindromeSubstring {

    static void printSubStr(String str, int low, int high)
    {

        System.out.println(str.substring(low, high + 1));
    }

    // This function prints the longest
    // palindrome substring of str[].
    // It also returns the length of the
    // longest palindrome
    static int longestPalindromeSubstring(String str)
    {
        // get length of input string
        int n = str.length();

        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean[][] table = new boolean[n][n];

        // All substrings of length 1 are palindromes, this indicate the single element
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        //if string at starting position equals to ending position
        //i is starting and i+1 is ending
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        // sub(i,j) is plaindrome provided -> table[i + 1][j - 1] && str.charAt(i) == str.charAt(j) and
        // above condition doesn't apply to length 1 and length two string

        // Check for lengths greater than 2.
        // k is length of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                //str.charAt(i) == str.charAt(j) is boundary condition to check if string is equal
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start,start + maxLength - 1);

        // return length of LPS
        return maxLength;
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {

        String str = "aaaabbaa";
        System.out.println("Length is: " + longestPalindromeSubstring(str));
    }

   // Time complexity: O(N2). A nested traversal is needed.
    //Auxiliary Space : O(N2). A matrix of size N*N is needed to store the table.
}
