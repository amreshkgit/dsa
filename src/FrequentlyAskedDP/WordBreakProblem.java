package FrequentlyAskedDP;

import java.util.*;

/**
 * we will start breaking the in tos segment of one word and remaining work we will send t o recursion
 * agin we will break it down into segment of two and answer of reaming we will get via recursion
 * Recursion intern going to do the same the thing it will again going to break it down of segment of one, two
 * and three ans soon.so,the complexity of this solution is huge 2^n
 * resson for 2^n is for each partition for each position will have two choices there are n positons so
 * there will n such choices for you have partition or u don't have partition
 * Instead of this will try to search the word in the beginning leetcode here search l the 'le' then 'lee' then 'leet'
 * then ssy you find leet word in the dictionary then search code in that serach 'c' then 'co' then 'cod' and soon
 */
public class WordBreakProblem {
    // set to hold dictionary values
    private static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        // loop to add all strings in dictionary set
        dictionary.addAll(Arrays.asList(temp_dictionary));
        List<String> dict = new ArrayList<>(dictionary);

        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("ilikesamsung",dict));
    }

    public static boolean wordBreak(String word)
    {
        int size = word.length();

        // base case
        if (size == 0)
            return true;

        //else check for all words
        for (int i = 1; i <= size; i++)
        {
            // Now we will first divide the word into two parts ,
            // the prefix will have a length of i and check if it is
            // present in dictionary ,if yes then we will check for
            // suffix of length size-i recursively. if both prefix and
            // suffix are present the word is found in dictionary.

            if (dictionary.contains(word.substring(0,i)) &&
                    wordBreak(word.substring(i,size)))
                return true;
        }

        // if all cases failed then return false
        return false;
    }

    public static boolean wordBreak(String s, List<String> dictionary) {
        // create a dp table to store results of subproblems
        // value of dp[i] will be true if string s can be segmented
        // into dictionary words from 0 to i.
        boolean[] dp = new boolean[s.length() + 1];

        // dp[0] is true because an empty string can always be segmented.
        dp[0] = true;

        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dictionary.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
