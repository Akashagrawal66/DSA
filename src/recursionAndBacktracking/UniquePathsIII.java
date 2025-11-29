package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of integers A of size N x M . There are 4 types of squares in it:
1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle
square exactly once.
Note: Rows are numbered from top to bottom and columns are numbered from left to right.
*/
public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int startR = 0, startC = 0, totalCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                } else if (grid[i][j] == 0) {
                    totalCount++;
                }
            }
        }
        return dfs(grid, visited, startR, startC, n, m, totalCount + 1);
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j, int n, int m, int totalCount) {
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || (grid[i][j] == -1) || (grid[i][j] == 2 && totalCount != 0)) {
            return 0;
        } else if (totalCount == 0 && grid[i][j] == 2) {
            return 1;
        }
        int count = 0;
        visited[i][j] = true;
        count += dfs(grid, visited, i + 1, j, n, m, totalCount - 1);
        count += dfs(grid, visited, i, j + 1, n, m, totalCount - 1);
        count += dfs(grid, visited, i - 1, j, n, m, totalCount - 1);
        count += dfs(grid, visited, i, j - 1, n, m, totalCount - 1);
        visited[i][j] = false;
        return count;
    }

    /*public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        boolean[][] visited = new boolean[n][m];
        int startR = 0, startC = 0, totalCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    startR = i;
                    startC = j;
                } else if (A.get(i).get(j) == 0) {
                    totalCount++;
                }
            }
        }
        int[][] dp = new int[n][m];
        return dfs(A, visited, startR, startC, n, m, totalCount + 1, dp);
    }

    private int dfs(ArrayList<ArrayList<Integer>> a, boolean[][] visited, int i, int j, int n, int m, int totalCount, int[][] dp) {
        if (i<0 || i >= n || j<0 || j >= m) {
            return 0;
        } else if (visited[i][j] || (a.get(i).get(j) == -1) ||(a.get(i).get(j) == 2 && totalCount != 0)) {
            return 0;
        } else if (totalCount == 0 && a.get(i).get(j) == 2) {
            return 1;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int count = 0;
        visited[i][j] = true;
        count += dfs(a, visited, i + 1, j, n, m, totalCount - 1, dp);
        count += dfs(a, visited, i, j + 1, n, m, totalCount - 1, dp);
        count += dfs(a, visited, i - 1, j, n, m, totalCount - 1, dp);
        count += dfs(a, visited, i, j - 1, n, m, totalCount - 1, dp);
        dp[i][j] = count;
        visited[i][j] = false;
        return dp[i][j];
    }*/

    public static void main(String[] args) {
        UniquePathsIII obj = new UniquePathsIII();
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(obj.uniquePathsIII(grid));
        /*ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(0);
        arr.add(0);
        arr.add(0);
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(0);
        arr1.add(0);
        arr1.add(0);
        arr1.add(0);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(0);
        arr2.add(0);
        arr2.add(2);
        arr2.add(-1);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(arr);
        list.add(arr1);
        list.add(arr2);
        System.out.println(obj.solve(list));*/
    }
}
