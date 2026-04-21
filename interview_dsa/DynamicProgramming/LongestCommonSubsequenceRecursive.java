package DynamicProgramming;

/**
 * Subsequence can be discontinues string where
 * as substring is sequential string
 */
public class LongestCommonSubsequenceRecursive {
    public static void main(String[] args) {
        String s1 ="abcabcbb";
        String s2 ="bbcbacba";

        int lcs = lcs(s1,s2,s1.length(),s2.length());
        System.out.println("Least common subsequence :: "+lcs);
    }

    public static int lcs(String s1, String s2, int firstStrLen, int secondStrLen){
        if(firstStrLen == 0 || secondStrLen == 0)
            return 0;
        //Check karo last string matches b/w two string and then decrease the len of both the string
        if(s1.charAt(firstStrLen-1) == s2.charAt(secondStrLen-1)){
            return 1+ lcs(s1,s2,firstStrLen-1,secondStrLen-1);
        }else{
            //Jab string match nahi kar raha ho. lekin ho sakta hai ki yadi hum pahla string pura le len
            // aur dusra string me last wala char hata den
            // aur ya dursa ka pura string le len aur pahle string me se last char nikal den
            return Math.max(lcs(s1,s2,firstStrLen-1,secondStrLen)
                    //iska matlab hai
                    ,lcs(s1,s2,firstStrLen,secondStrLen-1));
        }
    }
}
