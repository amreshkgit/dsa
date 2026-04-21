package DynamicProgramming;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s1 = "agbcba";
        /**
         * in order to make the this palindromic subsequence into lcs problem then we need to
         * find one more string here so reverse the given string and consider that String as
         * second string to find the lcs.
         */
        String s2 = new StringBuilder(s1).reverse().toString();
        int len = lcs(s1,s2,s1.length(),s2.length());
        System.out.println(len);
    }

    public static int lcs(String s1, String s2, int firstStrLen, int secondStrLen){
        if(firstStrLen == 0 || secondStrLen == 0)
            return 0;

        if(s1.charAt(firstStrLen-1) == s2.charAt(secondStrLen-1)){
            return 1+ lcs(s1,s2,firstStrLen-1,secondStrLen-1);
        }else{
            return Math.max(lcs(s1,s2,firstStrLen-1,secondStrLen),lcs(s1,s2,firstStrLen,secondStrLen-1));
        }
    }
}
