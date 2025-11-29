package hashing;

import java.util.HashMap;
import java.util.Map;

/*
Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation
of A similar strings.
Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
If it is possible, return 1, else return -1.
Input 1:
 A = 2
 B = "bbaabb"
Input 2:
 A = 2
 B = "bc"
Output 1:
 1
Output 2:
 -1
*/
public class ReplicatingSubString {
    public int solve(int A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) % A != 0) {
                return -1;
            }
        }
        return 1;
    }

}
