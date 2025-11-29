package array;

import java.util.HashMap;
import java.util.Map;

public class EqualNumOf0And1 {
    public int solve(int[] A) {
        int max = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                A[i] = -1;
            }
        }
        for (int i = 1; i < n; i++) {
            A[i] += A[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                max = Math.max(max, i + 1);
            } else if (map.containsKey(A[i])) {
                max = Math.max(max, i - map.get(A[i]));
            } else {
                map.put(A[i], i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        EqualNumOf0And1 obj = new EqualNumOf0And1();
        int[] A = {1,0,1,1,0,0,0,1};
        System.out.println(obj.solve(A));
    }
}
