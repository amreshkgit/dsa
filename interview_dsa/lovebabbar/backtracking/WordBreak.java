package lovebabbar.backtracking;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList(
                "mobile", "samsung", "sam", "sung", "man",
                "mango", "icecream", "and", "go", "i", "like",
                "ice", "cream");
        worBreak("ilikesamsung","",wordList);

    }

    public static void worBreak(String str, String ans, List<String> dict){
        if(str.length() ==0 ){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            String left = str.substring(0,i+1); //get the each prefix
            if(dict.contains(left)){ // search in the dictionary
                String right = str.substring(i+1);
                worBreak(right,ans+left+" ",dict);
            }
        }
    }
}
