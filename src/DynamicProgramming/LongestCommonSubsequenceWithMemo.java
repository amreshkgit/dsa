package DynamicProgramming;

public class LongestCommonSubsequenceWithMemo {
    static int[][]t;
    public static void main(String[] args) {
        String s1="abcdefg";
        String s2 ="abcedfg";
        t  = new int[s1.length()+1][s2.length()+1];
        int lcs = lcs(s1,s2,s1.length(),s2.length());
        System.out.println("Least common subsequence :: "+lcs);
    }

    public static int lcs(String s1, String s2, int firstLen, int secondLen){
        if(firstLen ==0 || secondLen ==0)
            return 0;

        if(t[firstLen][secondLen] != 0)
            return t[firstLen][secondLen];

        if(s1.charAt(firstLen-1) == s2.charAt(secondLen-1))
            return t[firstLen][secondLen]= 1+lcs(s1,s2,firstLen-1,secondLen-1);
        else
           return t[firstLen][secondLen]= Math.max(lcs(s1,s2,firstLen-1,secondLen),lcs(s1,s2,firstLen,secondLen-1));
    }
}
