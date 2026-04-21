package interviewProgramming;

import java.util.Stack;

public class BalancedParenthesesUsingStack {
    public static void main(String[] args) {
        String str = "[(])";
        char [] ch = str.toCharArray();
        System.out.println(isParenthesisBalanced(ch));

    }

    public static boolean isParenthesisBalanced(char[] ch) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {

            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {

                stack.push(ch[i]);
            }
            else if (ch[i] == ')' || ch[i] == '}' || ch[i] == ']') {

                if (stack.isEmpty() || !havePair(stack.peek(), ch[i]))

                    return false;
                else
                    stack.pop();
            }
        }
        return stack.empty() ? true:false;
    }

    // Function to check whether two characters are opening
// and closing of same type.
    public static boolean havePair(Character opening,Character closing)
    {
        if(opening == '(' && closing == ')') return true;
        else if(opening == '{' && closing == '}') return true;
        else if(opening == '[' && closing == ']') return true;
        return false;
    }
}

// Scan from left to right
// if opening symbol then add it to a stack
// if closing symbol, remove last opening symbol in the stack

//should end with an empty stack that means parenthesis are balanced