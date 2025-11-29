package stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
You are given a matrix A of size N x 2 which represents different operations.
Assume initially you have a stack-like data structure you have to perform operations on it.
Operations are of two types:
1 x: push an integer x onto the stack and return -1.
2 0: remove and return the most frequent element in the stack. This basically means the element which has the highest
count among all the elements currently in the stack.
If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
Input 1:
A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:
 A =  [
        [1, 5]
        [2, 0]
        [1, 4]   ]
Output 1:
 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:
 [-1, 5, -1]
*/
public class MaximumFrequencyStack {
    public int[] solve(int[][] A) {
        Map<Integer, Integer> hm = new HashMap<>();
        Map<Integer, Stack<Integer>> stackOfFrequencies = new HashMap<>();
        int maxFrequencyVal = 0;
        int len = A.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (A[i][0] == 1) {
                hm.put(A[i][1], hm.getOrDefault(A[i][1], 0) + 1);
                int num = hm.get(A[i][1]);
                if (maxFrequencyVal < num) {
                    maxFrequencyVal = num;
                }
                Stack<Integer> freq = stackOfFrequencies.get(num);
                if (freq == null) {
                    freq = new Stack<>();
                    freq.push(A[i][1]);
                    stackOfFrequencies.put(num, freq);
                } else {
                    freq.push(A[i][1]);
                }
                result[i] = -1;
            } else {
                Stack<Integer> freq = stackOfFrequencies.get(maxFrequencyVal);
                result[i] = freq.pop();
                hm.put(result[i], hm.getOrDefault(result[i], 0) - 1);
                if (hm.get(result[i]) == 0) {
                    hm.remove(result[i]);
                }
                if (freq.isEmpty()) {
                    stackOfFrequencies.remove(maxFrequencyVal);
                    maxFrequencyVal--;
                }
            }
        }
        return result;
    }
}
