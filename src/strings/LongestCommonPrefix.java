package strings;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
Input 1:
A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:
A = ["abab", "ab", "abcd"];
Output 1:
"a"
Output 2:
"ab"
*/
public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        String result = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            String str1 = A.get(i);
            result = commonPrefix(result, str1);
        }
        return result;
    }

    private String commonPrefix(String result, String str1) {
        int n = result.length();
        int m = str1.length();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (i<n&&i<m) {
            char ch = result.charAt(i);
            if (ch == str1.charAt(i)) {
                sb.append(ch);
                i++;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UniqueElements obj = new UniqueElements();
        ArrayList<String> str = new ArrayList<>();
        String[] arr = {"abab", "ab", "abcd"};
        obj.addToList(str, arr);

        LongestCommonPrefix obj2 = new LongestCommonPrefix();
        System.out.println(obj2.longestCommonPrefix(str));
    }
}
