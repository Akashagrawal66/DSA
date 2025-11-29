package maths;

import java.util.Arrays;

/*
Given an array of integers A, find and return the count of divisors of each element of the array.
NOTE: The order of the resultant array should be the same as the input array.
1 <= length of the array <= 100000
1 <= A[i] <= 10^6
* */
public class CountOfDivisors {
    public int[] solve(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = getNumberOfFactors(A[i]);
        }
        return result;
    }

    private int getNumberOfFactors(int n) {
        int count = 0;
        for (int i = 1; i * i <=n; i++) {
            if (n % i == 0 && n / i != i) {
                count += 2;
            } else if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountOfDivisors obj = new CountOfDivisors();
        int[] A = {2, 3, 4, 6};
        System.out.println(Arrays.toString(obj.solve(A)));
    }
}
