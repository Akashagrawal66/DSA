package searching;

import java.util.ArrayList;

/*
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
This matrix A has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.
NOTE: Rows are numbered from top to bottom, and columns are from left to right.
*/
public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size(), m = A.get(0).size(), i = 0, j = m - 1;
        while (i<n && j>=0) {
            int num = A.get(i).get(j);
            if(num < B) {
                i++;
            } else if (num > B) {
                j--;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
