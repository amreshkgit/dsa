package lovebabbar.backtracking;

import java.util.HashSet;
import java.util.Stack;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
      String str = "()())()";
      solution(str,getMinimumRemoval(str),new HashSet<>());
    }

    public static void solution(String str, int mra, HashSet<String> ans){
        if(mra == 0){
            int minimumRemovalNow = getMinimumRemoval(str);
            //when minimumRemovalNow is zero means parentheses is balanced then print
            if(minimumRemovalNow == 0){
                // ()()() we can get multiple while removing bracket at different location
                if(!ans.contains(str)){ // To avoid the same string can be formed after removing the another bracket
                    System.out.println(str);
                    ans.add(str);
                }
            }
        }
        for(int i=0; i<str.length();i++){
            String left = str.substring(0,i);
            String right = str.substring(i+1);
            solution(left+right,mra-1,ans);
        }
    }
    public static int getMinimumRemoval(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.size() == 0){
                    stack.push(c);
                }else if(stack.peek() == ')'){
                    stack.push(c);
                }else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}
