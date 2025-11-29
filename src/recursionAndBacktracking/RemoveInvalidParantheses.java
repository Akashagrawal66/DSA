package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'.
 * Remove the minimum number of invalid parentheses to make the input string valid.<br>
 * Return all possible results.<br>
 * You can return the results in any order.<br>
 * <b>Input 1:</b>
 * A = "()())()"<br>
 * Input 2:<br>
 * A = "(a)())()"<br>
 * Output 1:<br>
 * ["()()()", "(())()"]<br>
 * Output 2:<br>
 * ["(a)()()", "(a())()"]<br>
 */
public class RemoveInvalidParantheses {
   /* public ArrayList<String> solve(String A) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '(') {
                rmL++;
            } else if (ch == ')' && rmL != 0) {
                rmL--;
            } else if (ch == ')') {
                rmR++;
            }
        }
        Set<String> result = new HashSet<>();
        dfs(A, new StringBuilder(), 0, rmL, rmR, 0, result);
        return new ArrayList<>(result);
    }

    private void dfs(String a, StringBuilder stringBuilder, int index, int rmL, int rmR, int open, Set<String> result) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }

        if (index == a.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                result.add(stringBuilder.toString());
            }
            return;
        }

        char ch = a.charAt(index);
        int len = stringBuilder.length();
        if (ch == '(') {
            dfs(a, stringBuilder, index + 1, rmL - 1, rmR, open, result);
            dfs(a, stringBuilder.append(ch), index + 1, rmL, rmR, open + 1, result);
        } else if (ch == ')') {
            dfs(a, stringBuilder, index + 1, rmL, rmR - 1, open, result);
            dfs(a, stringBuilder.append(ch), index + 1, rmL, rmR, open - 1, result);
        } else {
            dfs(a, stringBuilder.append(ch), index + 1, rmL, rmR, open, result);
        }
        stringBuilder.setLength(len);
    }*/
    int max = -1;
    Set<String> set = new HashSet<>();
    public ArrayList<String> solve(String A) {
        dfs(A, 0, new StringBuilder(), 0, 0);
        return new ArrayList<>(set);
    }

    private void dfs(String str, int index, StringBuilder stringBuilder, int leftCount, int rightCount) {
        if(index == str.length()) {
            if(leftCount == rightCount) {
                if (stringBuilder.length() > max) {
                    max = stringBuilder.length();
                    set = new HashSet<>();
                    set.add(stringBuilder.toString());
                } else if (stringBuilder.length() == max) {
                    set.add(stringBuilder.toString());
                }
            }
            return;
        }
        char ch = str.charAt(index);
        if(ch == '(') {
            dfs(str, index+1, stringBuilder, leftCount, rightCount);
            stringBuilder.append(ch);
            dfs(str, index+1, stringBuilder, leftCount+1, rightCount);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        } else if (ch == ')') {
            dfs(str, index+1, stringBuilder, leftCount, rightCount);
            if(leftCount > rightCount) {
                stringBuilder.append(ch);
                dfs(str, index+1, stringBuilder, leftCount, rightCount+1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        } else {
            stringBuilder.append(ch);
            dfs(str, index+1, stringBuilder, leftCount, rightCount);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParantheses obj = new RemoveInvalidParantheses();
        System.out.println(obj.solve("(a)())()"));
    }
}
