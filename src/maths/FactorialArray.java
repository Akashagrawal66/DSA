package maths;

import java.util.*;

public class FactorialArray {
    public int solve(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> hm = getIntegerIntegerMap(A);
        int ans = 0;
        int M = 1000000007;
        List<Integer> list = new ArrayList<>(hm.values());
        Collections.sort(list);
        int count = numberOfSubSequence(1, 1, list.get(0), M);
        ans = (ans + count - 1);
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            if (val != list.get(i - 1)) {
                count = numberOfSubSequence(list.get(i - 1) + 1, count, val, M);
            }
            ans = (ans + count - 1) % M;
        }
        return ans;
    }

    private Map<Integer, Integer> getIntegerIntegerMap(int[] A) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n = A.length;
        int num = 1;
        if (A[0] != 1) {
            num = numberOfPrimes(2, A[0], 0);
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i < n; i++) {
            if (A[i] == 1) {
                continue;
            }
            if (A[i] != A[i - 1]) {
                num = numberOfPrimes(A[i - 1] + 1, A[i], num);
            }
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        return hm;
    }

    private int numberOfSubSequence(int start, long previousValue, Integer end, int mod) {
        for (int i = start; i <= end; i++) {
            previousValue = (previousValue * 2) % mod;
        }
        return (int) previousValue;
    }

    private int numberOfPrimes(int start, int end, int numOfPrimesTillStart) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count + numOfPrimesTillStart;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
