package maths;

import java.util.HashMap;
import java.util.Map;

public class PairSumDivisibleByM {
    public int solve(int[] A, int B) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : A) {
            int num = i%B;
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        int mod = (int)(1e9+7);
        for(int i=0;i<=B/2;i++) {
            int num = hm.getOrDefault(i, 0);
            if(i == 0 || ((B&1) == 0 && i == B/2)) {
                ans = (int)((ans + (((long)num*(num-1)/2)%mod))%mod);
            } else {
                int num2 = hm.getOrDefault(B-i, 0);
                ans = (int)((ans + (((long)num*num2)%mod))%mod);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {93,9,46,79,56,24,10,26,9,93,31,93,75,7,4,80,19,67,49,84,62,100,17,40,35,84,14,81,99,31,100,66,70,2,11,84,60,89,13,57,47,60,59,60,42,67,89,29,85,83,42,47,66,80,88,85,83,82,16,23,21,55,26,2,21,92,85,26,46,3,7,95,50,22,84,52,57,44,4,23,25,55,41,49};
        PairSumDivisibleByM obj = new PairSumDivisibleByM();
        System.out.println(obj.solve(A, 37));
    }
}
