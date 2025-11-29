package searching;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array of integers A of size N and an integer B.

The College library has N books. The ith book has A[i] number of pages.

You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.
Input 1:
A = [12, 34, 67, 90]
B = 2
Input 2:
A = [12, 15, 78]
B = 4
Output 1:
113
Output 2:
-1
*/
public class AllocateBooks {
    public int books(ArrayList<Integer> A, int B) {
        int n = A.size();
        if (B > n) {
            return -1;
        }
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int num : A) {
            low = Math.max(low, num);
            high += num;
        }
        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(A, B, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }


    public int allocateBooks(int[] A, int B) {
        int N = A.length;

        // If there are fewer books than students, allocation is not possible
        if (B > N) return -1;

        // Create prefix sum array to quickly calculate sum of any subarray
        int[] prefixSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        // DP table: dp[i][j] = min max pages for first i books and j students
        int[][] dp = new int[N + 1][B + 1];

        // Initialize base cases
        for (int i = 1; i <= N; i++) {
            dp[i][1] = prefixSum[i]; // One student gets all books
        }

        for (int j = 1; j <= B; j++) {
            dp[1][j] = A[0]; // Only one book
        }

        // Fill DP table
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= B; j++) {
                int minVal = Integer.MAX_VALUE;

                // Try all possible partitions
                for (int k = 1; k < i; k++) {
                    int left = dp[k][j - 1];
                    int right = prefixSum[i] - prefixSum[k];
                    int maxPages = Math.max(left, right);
                    minVal = Math.min(minVal, maxPages);
                }
                dp[i][j] = minVal;
            }
        }
        for (int[] i: dp) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        return dp[N][B];
    }


    private boolean check(ArrayList<Integer> a, int b, int mid) {
        int required = 1;
        int curr = 0;
        for (int num: a) {
            if(num > mid) {
                return false;
            }
            if (curr+num > mid) {
                required += 1;
                curr = num;
                if(required > b) {
                    return false;
                }
            } else {
                curr += num;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AllocateBooks obj = new AllocateBooks();
        UniqueElements obj2 = new UniqueElements();

        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {12, 34, 67, 90};
        obj2.addToList(list, arr);

        System.out.println(obj.books(list, 2));
        obj.allocateBooks(arr, 2);
    }
}
