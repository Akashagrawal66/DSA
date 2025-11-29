package stack;

import java.util.Stack;

/*
Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
Check whether A has redundant braces or not.
NOTE: A will be always a valid expression and will not contain any white spaces.
Input 1:
 A = "((a+b))"
Input 2:
 A = "(a+(a+b))"
Output 1:
 1
Output 2:
 0
*/
public class RedundantBraces {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == ')') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    return 1;
                }
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                if (!stack.isEmpty())
                    stack.pop();
            } else if (ch == '(' || !Character.isLetter(ch)) {
                stack.push(ch);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        RedundantBraces obj = new RedundantBraces();
        System.out.println(obj.braces("((a+b))"));
    }
}
