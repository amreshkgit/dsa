package DynamicProgramming;

public class LongestCommonSubstringTopDown {
    static int[][] t;
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "abcfegr";
        t = new int[s1.length()+1][s2.length()+1];
        int lcs = lcs(s1,s2,s1.length(),s2.length());
        System.out.println("Least common substring :: "+lcs);
    }

    //time complexity O(m*n)
    //space complexity O(m*n)
    public static int lcs(String s1 , String s2 ,int firsLen , int secondLen) {
        int result = 0;
        for (int i = 1; i < firsLen + 1; i++) {
            for (int j = 1; j < secondLen + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                     t[i][j] = 1 + t[i - 1][j - 1];
                     result = Math.max(result,t[i][j]);
                } else {
                    t[i][j] = 0; //to make length zero when there is no character match
                }
            }
        }
        return result;
    }
}
