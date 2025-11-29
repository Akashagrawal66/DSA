package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
Given a string A and a dictionary of words B, add spaces in A to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences.
Note: Make sure the strings are sorted in your result.

Input Format:
The first argument is a string, A.
The second argument is an array of strings, B.

Output Format:
Return a vector of strings representing the answer as described in the problem statement.
Input 1:
    A = "b"
    B = ["aabbb"]
Output 1:
    []

Input 1:
    A = "catsanddog",
    B = ["cat", "cats", "and", "sand", "dog"]
Output 1:
    ["cat sand dog", "cats and dog"]
*/
public class WordBreak2 {
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        ArrayList<String> result = new ArrayList<>();
        dfs(A, B, new StringBuilder(),new StringBuilder(), result, 0);
        return result;
    }

    private void dfs(String A, ArrayList<String> B, StringBuilder currStr, StringBuilder resultantStr, ArrayList<String> result, int index) {
        if (index == A.length()) {
            result.add(resultantStr.toString().trim());
            return;
        }
        for (int i = index; i < A.length(); i++) {
            char ch = A.charAt(i);
            currStr.append(ch);
            if(B.contains(currStr.toString())) {
                resultantStr.append(currStr).append(" ");
                dfs(A, B, new StringBuilder(),resultantStr, result, i + 1);
                resultantStr.delete(resultantStr.length()-currStr.length(), resultantStr.length());
            }
        }
    }

    public static void main(String[] args) {
        WordBreak2 obj = new WordBreak2();
        ArrayList<String> B = new ArrayList<>();
        B.add("bababbbb");
        B.add("bbbabaa");
        B.add("abbb");
        B.add("a");
        B.add("aabbaab");
        B.add("b");
        B.add("dog");
        System.out.println(obj.wordBreak("aabbbabaaabbbabaabaab", B));
    }
}
