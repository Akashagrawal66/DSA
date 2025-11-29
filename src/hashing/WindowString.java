package hashing;

import java.util.HashMap;
import java.util.Map;

/*Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
Note:
If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
Input 1:
 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:
 A = "Aa91b"
 B = "ab"
Output 1:
 "BANC"
Output 2:
 "a91b"
*/
public class WindowString {

    public String minWindow(String A, String B) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        int length = 0;
        int total = 0;
        for (int head = 0, tail = 0; tail < A.length(); tail++) {
            if (counts.get(A.charAt(tail)) == null) {
                continue;
            }
            counts.put(A.charAt(tail), counts.get(A.charAt(tail)) - 1);
            if (counts.get(A.charAt(tail)) >= 0) {
                total++;
            }
            if (total == B.length()) {
                while (counts.get(A.charAt(head)) == null || counts.get(A.charAt(head)) < 0) {
                    if (counts.get(A.charAt(head)) != null) counts.put(A.charAt(head), counts.get(A.charAt(head)) + 1);
                    head++;
                }
                if (length == 0 || tail - head + 1 < length) {
                    length = tail - head + 1;
                    start = head;
                }
            }
        }
        return A.substring(start, start + length);
    }
}
