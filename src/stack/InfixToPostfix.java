package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
Find and return the postfix expression of A.

NOTE:
^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.
Input 1:
 A = "x^y/(a*z)+b"
Input 2:
 A = "a+b*(c^d-e)^(f+g*h)-i"
Example Output:
Output 1:
"xy^az*///b+"
//Output 2:
//"abcd^e-fgh*+^*+i-"
//*/
public class InfixToPostfix {
    public String solve(String A) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 0);
        precedence.put('-', 0);
        precedence.put('*', 1);
        precedence.put('/', 1);
        precedence.put('^', 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' && precedence.get(ch) <= precedence.get(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        InfixToPostfix obj = new InfixToPostfix();
        System.out.println(obj.solve("a+b*(c^d-e)^(f+g*h)-i"));
    }
}
