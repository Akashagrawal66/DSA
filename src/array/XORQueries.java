package array;

import java.util.Arrays;

public class XORQueries {
    public int[][] solve(int[] A, int[][] B) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            A[i] = A[i]+A[i-1];
        }
        int m = B.length;
        int[][] result = new int[m][2];
        for (int i = 0; i < m; i++) {
            int left = B[i][0] - 1;
            int right = B[i][1] - 1;
            int num = A[right];
            if (left != 0) {
                num -= A[left - 1];
            }
            result[i][0] = (num & 1);
            result[i][1] = (right-left+1-num);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 0, 0, 1};
        int[][] B = {{2, 4}, {1, 5}, {3, 5}};
        XORQueries obj = new XORQueries();
        int[][] arr = obj.solve(A, B);
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
