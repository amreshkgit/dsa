package lovebabbar.string;

/**
 * Write a Code to check whether one string is a rotation of another
 */
public class kmpalgorithm {
    public static void main(String[] args) {
        String str = "abxabcabcaby";
        String subString = "abcaby";
        kmpalgorithm ss = new kmpalgorithm();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
    }

    /**
     * @param s1
     * @param s2
     * @return
     */
/*    public static boolean checkRotation(String s1,String s2){
        *//**
         * Whey we are adding s1+s1?
         * because s1+s1 all the rotation comb of this s2 contained as sbustring in this s
         * if we find substring equals to this target string then we can assume that s1 and s2 are
         * rotation of each other.
         *
         *  complexity measure
         *  O(n1+n2) where n1 is length of s and n2 is len of s2 / or pattern
         *  here we can see that s is 2*s1
         *  O(2n+n) which nothing but O(n)
         *//*

    }*/

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     * Time complexity is O(m+n)
     * Space complexity is O(n)
     *
     * we are not doihg the linear search rather we are using temp array to jump to the correct location
     */
    private int[] computeTemporaryArray(char[] pattern){
        //Step1. form lps array using pattern
        int [] lps = new int[pattern.length];
        int i =0;
        for(int j=1; j < pattern.length;){
            // When match move index and j both
            if(pattern[j] == pattern[i]){
                lps[j] = i + 1; // lps index represents the len of then longest suffix which also the prefix
                i++;
                j++;
            }else{
                if(i != 0){
                    // when c and y doesn't match then move back on index and see the value of previous
                    // index here it value is 0 then move to index zero because index was 1 and we are doing
                    // index -1 , so it will be zero at zero index char is 'a' will match with 'y' and
                    //it is not matching then it will add zero
                    i = lps[i-1];
                }else{
                    lps[j] =0;
                    j++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public boolean KMP(char []text, char []pattern){

        int[] lps = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                //Whenver there is no matching then we will move to previous location and look at value
                //  and then will match with the value on the location
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }
}
