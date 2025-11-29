package maths;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortedPermutationRankWithRepeats {

    public int findRank(String A) {
        int n = A.length();
        int mod = 1000003;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        Map<Integer, Integer> inverseModVal = new HashMap<>();
        for (int i : freqMap.values()) {
            if (i > 1) {
                inverseModVal.put(i, inverseModVal.getOrDefault(i, inverseModulo(fact(i, mod), mod)));
            }
        }
        int rank = 0;
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            int duplicateFactVal = 1;
            char iChar = A.charAt(i);
            Set<Character> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                char ch = A.charAt(j);
                System.out.println("char :"+ch);

                int num = freqMap.get(ch);
                System.out.println("num :"+num);
                if (ch < iChar) {
                    count++;
                }
                inverseModVal.computeIfAbsent(num, k -> inverseModulo(fact(k, mod), mod));
                if (set.add(ch)) {
                    duplicateFactVal = (int)(((long)duplicateFactVal * inverseModVal.get(num))%mod);
                }
            }
            System.out.println(duplicateFactVal+"--");
            rank = (int) ((rank + ((long) count * fact(n - i - 1, mod) * duplicateFactVal)) % mod);
            System.out.println(rank);
            freqMap.put(iChar, freqMap.getOrDefault(iChar, 0) - 1);
        }
        return rank + 1;
    }

    private int inverseModulo(int fact, int mod) {
        int var = 1;
        int B = mod - 2;
        while (B > 1) {
            if ((B & 1) == 1) {
                B -= 1;
                var = (int) (((long) var * fact) % mod);
            }
            B /= 2;
            fact = (int) (((long) fact * fact) % mod);
        }
        return (int) (((long) var * fact) % mod);
    }

    private int fact(int n, int mod) {
        if (n <= 1) {
            return 1;
        }
        return (int) (((long) n * fact(n - 1, mod)) % mod);
    }

    public static void main(String[] args) {
        String A = "bbbbaaaa";
        SortedPermutationRankWithRepeats obj = new SortedPermutationRankWithRepeats();
        System.out.println(obj.findRank(A));
    }
}
