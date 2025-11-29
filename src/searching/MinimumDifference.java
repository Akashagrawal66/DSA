package searching;

import java.util.ArrayList;
import java.util.Collections;

/*
You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in
such a way that the cost of the newly built array is minimized.
The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.
So if the newly built array is X, the element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.
Determine the minimum cost of the newly built array.
Input 1:
 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]
Input 2:
 A = 3
 B = 2
 C = [ [7, 3]
       [2, 1]
       [4, 9] ]
Output 1:
 0
Output 2:
 1
*/
public class MinimumDifference {
    public int solve(int A, int B, ArrayList<ArrayList<Integer>> C) {
        for (int i = 0; i < A; i++) {
            Collections.sort(C.get(i));
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A - 1; i++) {
            for (int j = 0; j < B; j++) {
                int index = binarySearch(C.get(i + 1), B, C.get(i).get(j));
                ans = Math.min(ans, Math.abs(C.get(i).get(j) - C.get(i+1).get(index)));
                if(index-1 >= 0) {
                    ans = Math.min(ans, Math.abs(C.get(i).get(j) - C.get(i+1).get(index-1)));
                }
            }
        }
        return ans;
    }

    private int binarySearch(ArrayList<Integer> arr, int B, int num) {
        int low = 0, high = B-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            if(arr.get(mid) < num) {
                low = mid+1;
            } else if (arr.get(mid) > num) {
                high = mid;
            } else {
                return mid;
            }
        }
        return low;
    }
}
