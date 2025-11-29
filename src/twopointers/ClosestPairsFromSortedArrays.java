package twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C
and the pair has one element from each array.
More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i
then return the one with minimum j.

Return an array with two elements {A[i], B[j]}.
*/
public class ClosestPairsFromSortedArrays {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int min = Integer.MAX_VALUE;
        int numA = Integer.MAX_VALUE;
        int numB = Integer.MAX_VALUE;
        int i= 0, j=B.size()-1;
        while (i<A.size() && j>=0) {
            int diff = (A.get(i)+B.get(j) - C);
            if (diff < min) {
                min = diff;
                numA = A.get(i);
                numB = B.get(j);
            } else if (diff == min) {
                if (A.get(i) < numA) {
                    numA = A.get(i);
                    numB = B.get(j);
                } else if (A.get(i) == numA && B.get(j) <numB) {
                    numB = B.get(j);
                }
            }
            if (diff < 0) {
                j--;
            } else if (diff > 0) {
                i++;
            } else {
                break;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(numA);
        result.add(numB);
        return result;
    }
}
