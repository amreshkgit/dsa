package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RearangeTheSetenceProblem {
    public static void main(String[] args) {
        String sentence ="Houston we have a problem";
        //String sentence = "It is the hottest sun in the beach";
        rearrangeTheWord(sentence);
    }
    public static void rearrangeTheWord(String str) {
        String[] st = str.split(" ");
        List<String> s = new ArrayList<>(Arrays.asList(st));
        System.out.println("The original list without sorting");
        System.out.println(s);
        s.sort(Comparator.comparingInt(String::length));
        System.out.println("The same list after sorting string by length");
        System.out.println(s);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.size(); i++) {
            if (i == 0 && s.get(i).length() > 1) {
                buffer.append(Character.toUpperCase(s.get(i).charAt(0))+s.get(i).substring(1)+" ");
            } else if (i==0){
                buffer.append(s.get(i).toUpperCase() +" ");
            }
            if(Character.isUpperCase(s.get(i).charAt(0))){
                if(i >=1)
                    buffer.append(s.get(i).toLowerCase()+" ");
            }else{
                if(i >=1)
                    buffer.append(s.get(i).toLowerCase()+" ");
            }
        }
        System.out.println(buffer.toString().trim()+".");
    }
}
