package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SumOfMatrixForQueries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        // prefix sum
        int n = A.length;
        int m = A[0].length;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                A[i][j] = (A[i][j] + A[i][j - 1]) % mod;
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                A[i][j] = (A[i][j] + A[i - 1][j]) % mod;
            }
        }
        int[] result = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int b = B[i] - 1;
            int c = C[i] - 1;
            int d = D[i] - 1;
            int e = E[i] - 1;
            int sum = A[d][e] % mod;
            if (b != 0 && c != 0) {
                sum = (sum - A[b - 1][e] - A[d][c - 1] + A[b - 1][c - 1]) % mod;
            } else if (b != 0) {
                sum = (sum - A[b - 1][e]);
            } else if (c != 0) {
                sum = (sum - A[d][c - 1]);
            }
            while (sum < 0)
                sum += 1000000007;
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] B = {1, 2};
        int[] C = {1, 2};
        int[] D = {2, 3};
        int[] E = {2, 3};
        SumOfMatrixForQueries obj = new SumOfMatrixForQueries();
        System.out.println(Arrays.toString(obj.solve(A, B, C, D, E)));
    }
}
