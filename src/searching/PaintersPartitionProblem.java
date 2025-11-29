package searching;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Comparator;

/*
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to
paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous
sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.
Input 1:
 A = 2
 B = 5
 C = [1, 10]
Input 2:
 A = 10
 B = 1
 C = [1, 8, 11, 3]
Output 1:
 50
Output 2:
 11
*/
public class PaintersPartitionProblem {
    public int paint(int A, int B, ArrayList<Integer> C) {
        int mod = (int) (1e7 + 3);
        long minTime = 0;
        long maxTime = Long.MAX_VALUE;
        long result = 0;
        while (minTime <= maxTime) {
            long mid = minTime + (maxTime - minTime) / 2;
            if (isPossible(A, B, C, mid)) {
                result = mid;
                maxTime = mid - 1;
            } else {
                minTime = mid + 1;
            }
        }
        return (int) (result % mod);
    }

    private boolean isPossible(int a, int b, ArrayList<Integer> c, long maxTime) {
        int workers = 0;
        int mod = (int) (1e7 + 3);
        long total = 0;
        int i = 0;
        while (i < c.size() && workers < a) {
            int size = c.get(i);
            total = (total + (long) size * b);
            if (total > maxTime) {
                total = 0;
                workers++;
            } else {
                i++;
            }
        }
        return i == c.size();
    }

    public static void main(String[] args) {
        PaintersPartitionProblem obj = new PaintersPartitionProblem();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1000000, 1000000};
        UniqueElements obj2 = new UniqueElements();
        obj2.addToList(list, arr);
        System.out.println(obj.paint(1, 1000000, list));
    }
}
