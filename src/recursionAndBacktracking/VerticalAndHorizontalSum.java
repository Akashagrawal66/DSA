package recursionAndBacktracking;

import java.util.ArrayList;

/*
Given a matrix B, of size N x M, you are allowed to do at most A special operations on this grid
such that there is no vertical or horizontal contiguous subArray that has a sum greater than C.
A special operation involves multiplying any element by -1 i.e., changing its sign.
Return 1 if it is possible to achieve the answer, otherwise 0.
*/
public class VerticalAndHorizontalSum {
    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        return dfs(A, B, C, 0, 0, B.size(), B.get(0).size());
    }

    private int dfs(int A, ArrayList<ArrayList<Integer>> B, int C, int row, int column, int n, int m) {
        if (isValid2D(B, C, n, m)) {
            return 1;
        } else if (A == 0) {
            if (isValid2D(B, C, n, m)) {
                return 1;
            }
            return 0;
        } else if (column >= m) {
            row++;
            return dfs(A, B, C, row, 0, n, m);
        } else if (row >= n) {
            return 0;
        }
        int num = B.get(row).get(column);
        B.get(row).set(column, -1 * (num));
        if (dfs(A - 1, B, C, row, column + 1, n, m) == 1) {
            return 1;
        }
        B.get(row).set(column, num);
        return dfs(A, B, C, row, column + 1, n, m);
    }

    private boolean isValid2D(ArrayList<ArrayList<Integer>> B, int C, int n, int m) {
        // Row Wise Sum
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int max = 0;
            for (int j = 0; j < m; j++) {
                sum += B.get(i).get(j);
                if (sum < 0) {
                    sum = 0;
                }
                if (max < sum) {
                    max = sum;
                }
            }
            if (max > C) {
                return false;
            }
        }
        // Column Wise Sum
        for (int i = 0; i < m; i++) {
            int sum = 0;
            int max = 0;
            for (int j = 0; j < n; j++) {
                sum += B.get(j).get(i);
                if (sum < 0) {
                    sum = 0;
                }
                if (max < sum) {
                    max = sum;
                }
            }
            if (max > C) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        VerticalAndHorizontalSum obj = new VerticalAndHorizontalSum();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr1.add(1);
        arr1.add(1);
        arr1.add(1);
        arr2.add(1);
        arr2.add(1);
        arr2.add(1);
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(arr);
        B.add(arr1);
        B.add(arr2);
        System.out.println(obj.solve(3, B, 2));
    }
}
