package array;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfJumps {

    public int solve(int[] A) {
//        int val = recursion(0, A, new HashMap<>());
//        if(val == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return val;

        int jumps = 0, left = 0, right = 0;
        while (right < A.length - 1) {
            int max = 0;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, i + A[i]);
            }
            if (max == 0) {
                return -1;
            }
            left = right + 1;
            right = max;
            jumps++;
        }
        return jumps;
    }

    private int recursion(int jumpToIndex, int[] A, HashMap<Integer, Integer> map) {
        if (map.containsKey(jumpToIndex)) {
            return map.get(jumpToIndex);
        } else if (jumpToIndex >= A.length - 1) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = jumpToIndex + 1; i <= jumpToIndex + A[jumpToIndex] && i < A.length; i++) {
            int val = recursion(i, A, map);
            if (val != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + val);
            }
        }
        map.put(jumpToIndex, ans);
        return map.get(jumpToIndex);
    }

    public static void main(String[] args) {
        MinimumNumberOfJumps obj = new MinimumNumberOfJumps();
        int[] A = {1, 1, 0, 4, 4};
        System.out.println(obj.solve(A));
    }
}
