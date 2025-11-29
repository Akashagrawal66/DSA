package hashing;

import java.util.*;

/*
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1, else return 0.
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [4, -1, 1]
Output 1:
 0
Output 2:
 1
*/
public class SubArrayWithZeroSum {
    public int solve(ArrayList<Integer> A) {
        Set<Long> set = new HashSet<>();
        long sum = 0;
        for (Integer integer : A) {
            sum += integer;
            if (!set.add(sum) || sum == 0) {
                return 1;
            }
        }
        return 0;
    }
}
