package stack;

import java.util.Stack;

/*
Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
Input 1:
 A = "-(a+b+c)"
 B = "-a-b-c"
Input 2:
 A = "a-b-(c-d)"
 B = "a-b-c-d"
Output 1:
 1
Output 2:
 0
*/
public class CheckTwoBracketExpressions {
    public int solve(String A, String B) {
        int[] arr = processString(A);
        int[] arr2 = processString(B);
        for (int i = 0; i < 26; i++) {
            if (arr[i] != arr2[i]) {
                return 0;
            }
        }
        return 1;
    }

    private int[] processString(String A) {
        int[] arr = new int[26];
        Stack<Boolean> stack = new Stack<>();
        stack.push(true);
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '+' || ch == '-') {
                continue;
            }
            if (ch == '(') {
                stack.push((adjacentSign(A, i) == 1) == stack.peek());
            } else if (ch == ')') {
                stack.pop();
            } else {
                if (stack.peek()) {
                    arr[ch - 'a'] = adjacentSign(A, i);
                } else {
                    arr[ch - 'a'] = -1 * adjacentSign(A, i);
                }
            }
        }
        return arr;
    }

    private int adjacentSign(String str, int i) {
        if (i == 0 || str.charAt(i - 1) == '+' || str.charAt(i - 1) == '(') {
            return 1;
        }
        return -1;
    }
}
