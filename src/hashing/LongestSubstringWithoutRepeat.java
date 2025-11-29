package hashing;

import java.util.HashSet;
import java.util.Set;

/*Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest substring
that contains no repeating characters. The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.
Your task is to return an integer representing the "GOOD"ness of string A.

Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.
Input 1:
 A = "abcabcbb"
Input 2:
 A = "AaaA"
Output 1:
 3
Output 2:
 2
 */
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        int i = 0, j = 0;
        Set<Character> chars = new HashSet<>();
        int max = -1;
        while (j < A.length()) {
            char ch = A.charAt(j);
            if (chars.contains(ch)) {
                max = Math.max(max, (j - i));
                while (i < j && chars.contains(ch)) {
                    char ch1 = A.charAt(i);
                    chars.remove(ch1);
                    i++;
                }
            }
            chars.add(ch);
            j++;
        }
        max = Math.max(max, (j - i));
        return max;
    }
}
