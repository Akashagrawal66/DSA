package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
You are given two strings, A and B, of size N and M, respectively.
You have to find the count of all permutations of A present in B as a substring.
You can assume a string will have only lowercase letters.
Input 1:
 A = "abc"
 B = "abcbacabc"
Input 2:
 A = "aca"
 B = "acaa"
Output 1:
 5
Output 2:
 2
*/
public class PermutationsOfAInB {
    public int solve(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        int n = A.length();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        int count = 0;
        for (int i = 0, j = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            if ((i - j + 1) == n) {
                if (checkAndCompareTwoMaps(map, map2)) {
                    count++;
                }
                char ch1 = B.charAt(j);
                int freq = map2.get(ch1);
                if(freq - 1 == 0) {
                    map2.remove(ch1);
                } else {
                    map2.put(ch1, freq-1);
                }
                j++;
            }
        }
        return count;
    }

    private boolean checkAndCompareTwoMaps(Map<Character, Integer> map, Map<Character, Integer> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (var i : map2.keySet()) {
            if (!map.containsKey(i) || !Objects.equals(map.get(i), map2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationsOfAInB obj = new PermutationsOfAInB();
        System.out.println(obj.solve("p", "pccdpeeooadeocdoacddapacaecb"));
    }
}
