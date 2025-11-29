package searching;

import java.util.ArrayList;

/*
Given a matrix of integers A of size N x M in which each row is sorted.
Find and return the overall median of matrix A.
NOTE: No extra memory is allowed.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
Input 1:
    A = [ [1, 3, 5],
          [2, 6, 9],
          [3, 6, 9] ]
Input 2:
    A = [ [5, 17, 100] ]
Output 1:
    5
Output 2:
    17
*/
public class MatrixMedian {

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = A.size();
        int m = A.get(0).size();
        for (ArrayList<Integer> integerArrayList : A) {
            min = Math.min(min, integerArrayList.get(0));
            max = Math.max(max, integerArrayList.get(m - 1));
        }
        int desired = (n*m + 1) /2;
        while (min < max) {
            int mid = min + (max - min) / 2;

            int count = 0;
            for (ArrayList<Integer> integers : A) {
                count += upperBound(integers, mid);
            }
            if (count < desired) {
                min = mid+1;
            }else {
                max = mid;
            }
        }
        return min;
    }

    private int upperBound(ArrayList<Integer> arr, int num) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) <= num) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
