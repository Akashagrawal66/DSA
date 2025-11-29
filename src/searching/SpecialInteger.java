package searching;

import sorting.UniqueElements;

import java.util.ArrayList;

/*
Given an array of integers A and an integer B,
find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
Input 1:
    A = [1, 2, 3, 4, 5]
    B = 10
Input 2:
    A = [5, 17, 100, 11]
    B = 130
Output 1:
    2
Output 2:
    3
*/
public class SpecialInteger {

    public int solve(ArrayList<Integer> A, int B) {
        int low = 1, high = A.size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (upperBound(A, B, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean upperBound(ArrayList<Integer> A, int num, int subArraySize) {
        int low = subArraySize - 1;
        long sum = 0L, maxSum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (i > low) {
                sum -= A.get(i - subArraySize);
            }
            if (i >= low) {
                maxSum = Math.max(maxSum, sum);
            }
            if (maxSum > num) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SpecialInteger obj = new SpecialInteger();
        UniqueElements obj2 = new UniqueElements();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1, 1000000000};
        obj2.addToList(list, arr);
        System.out.println(obj.solve(list, 1000000000));
    }
}
