package DynamicProgramming;

public class LongestCommonSubstringRecursive {
    public static void main(String[] args) {
        String s1= "abcdef";
        String s2 = "abcdfg";
        int lcsCount = lcsSubstr(s1,s2,s1.length(),s2.length(),0);
        System.out.println("Longest common substring :: "+lcsCount);
    }

    public static int lcsSubstr(String s1, String s2, int len1,int len2, int lcsCount){

        if(len1 <=0 || len2 <=0)
            return lcsCount;

        int lcsCount1 =lcsCount;
        if(s1.charAt(len1-1) == s2.charAt(len2-1))
            lcsCount1= lcsSubstr(s1,s2,len1-1,len2-1,lcsCount+1);

            int lcsCount2 = lcsSubstr(s1,s2,len1-1,len2,0);
            int lcsCount3 = lcsSubstr(s1,s2,len1,len2-1,0);
            return Math.max(lcsCount1,Math.max(lcsCount2,lcsCount3));

    }
}
