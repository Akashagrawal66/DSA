package queues;

import sorting.UniqueElements;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
Given an array A of both positive and negative integers.
Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
Input 1:
 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:
 A = [2, -1, 3]
 B = 2
Output 1:
 18
Output 2:
 3
*/
public class SumOfMinAndMax {
    public int solve(ArrayList<Integer> A, int B) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int n = A.size();
        int mod = (int) (1e9 + 7);
        int result = 0;
        for (int i = 0; i < B && i < n; i++) {
            int num = A.get(i);
            while (!maxQ.isEmpty() && A.get(maxQ.peekLast()) <= num) {
                maxQ.pollLast();
            }
            maxQ.add(i);
            while (!minQ.isEmpty() && A.get(minQ.peekLast()) >= num) {
                minQ.pollLast();
            }
            minQ.add(i);
        }
        result = (int) ((result + (long) (A.get(maxQ.peek()) + A.get(minQ.peek()))) % mod);
        for (int i = B; i < n; i++) {
            int indexToBeRemoved = i - B;
            int numToBeConsidered = A.get(i);
            if (indexToBeRemoved == maxQ.peek()) {
                maxQ.poll();
            }
            while (!maxQ.isEmpty() && A.get(maxQ.peekLast()) <= numToBeConsidered) {
                maxQ.pollLast();
            }
            maxQ.add(i);
            if (indexToBeRemoved == minQ.peek()) {
                minQ.poll();
            }
            while (!minQ.isEmpty() && A.get(minQ.peekLast()) >= numToBeConsidered) {
                minQ.pollLast();
            }
            minQ.add(i);
            result = (int) ((result + (long) (A.get(maxQ.peek()) + A.get(minQ.peek()))) % mod);
        }
        return result;
    }

    public static void main(String[] args) {
        UniqueElements obj = new UniqueElements();
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        ArrayList<Integer> list = new ArrayList<>();
        obj.addToList(list, arr);
        SumOfMinAndMax obj2 = new SumOfMinAndMax();
        System.out.println(obj2.solve(list, 4));
    }
}
