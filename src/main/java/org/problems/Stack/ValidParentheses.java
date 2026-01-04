package org.problems.Stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "[{()[]}()]";

        System.out.println(isValidParentheses(s));
    }

    private static boolean isValidParentheses(String s){

        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : charArray){

            if (c == '['){
                stack.push(']');
            } else if (c =='{') {
                stack.push('}');
            } else if (c == '('){
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
