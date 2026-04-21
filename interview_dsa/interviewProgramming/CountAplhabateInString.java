package interviewProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountAplhabateInString {
    public static void main(String[] args) {
        String str ="AAAABBCDDDDD";
        char [] ch = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0 ; i<ch.length;i++){
            if(!map.containsKey(ch[i])){
                map.put(ch[i],1);
            }else {
                map.put(ch[i],map.get(ch[i])+1);
            }
        }
        StringBuilder builder = new StringBuilder();
        for(Map.Entry entry : map.entrySet()){
            builder.append(entry.getKey()+""+entry.getValue()+"");
        }
        System.out.println(builder.toString());
    }
}
