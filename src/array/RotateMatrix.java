package array;

import java.util.Arrays;

public class RotateMatrix {
    /*
    Problem Description
    You are given an n x n 2D matrix A representing an image.
    Rotate the image by 90 degrees (clockwise).
    You need to do this in place.
    Note: If you end up using an additional array, you will only receive partial score.

    Problem Constraints
    1 <= n <= 1000
    Input Format
    First argument is a 2D matrix A of integers

    Output Format
    Return the 2D rotated matrix.

    Example Input 1:
    [
        [1, 2],
        [3, 4]
    ]
    Input 2:
    [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    Example Output
    Output 1:
    [
        [3, 1],
        [4, 2]
    ]
    Output 2:
    [
        [7, 4, 1],
        [8, 5, 2],
        [9, 6, 3]
    ]
    */
    public static void main(String[] args) {
        RotateMatrix matrix = new RotateMatrix();
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        matrix.solve(nums);
        matrix.solveDiff(nums);
        for (int[] i: nums) {
            System.out.println(Arrays.toString(i));
        }
    }

    public void solve(int[][] A) {
        int i = 0, j = 0;
        int c = 0;
        int n = A.length;
        while (c < n / 2) {
            int[] nums = new int[n - 1];
            int k = 0;
            while (j < n - 1 - c) {
                nums[k++] = A[i][j++];
            }
            k = 0;
            while (i < n - 1 - c) {
                int temp = nums[k];
                nums[k++] = A[i][j];
                A[i++][j] = temp;
            }
            k = 0;
            while (j > c) {
                int temp = nums[k];
                nums[k++] = A[i][j];
                A[i][j--] = temp;
            }
            k = 0;
            while (i > c) {
                int temp = nums[k];
                nums[k++] = A[i][j];
                A[i--][j] = temp;
            }
            k=0;
            while (j< n-1-c) {
                A[i][j++] = nums[k++];
            }
            c++;
            i = j = c;
        }

        for (int[] nums: A) {
            System.out.println(Arrays.toString(nums));
        }
    }

    public void solveDiff(int[][] A) {
        int n = A.length;
        for(int i=0;i<n/2;i++) {
            for(int j=i;j<n-1-i;j++) {
                int temp = A[i][j];
                A[i][j] = A[n-1-j][i];
                A[n-1-j][i] = A[n-1-i][n-1-j];
                A[n-1-i][n-1-j] = A[j][n-1-i];
                A[j][n-1-i] = temp;
            }
            for (int[] nums: A) {
                System.out.println(Arrays.toString(nums));
            }
            System.out.println("-----------------------------");
        }
    }
}
