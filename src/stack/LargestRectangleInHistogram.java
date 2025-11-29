package stack;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Given an array of integers A.
A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.
Input 1:
 A = [2, 1, 5, 6, 2, 3]
Input 2:
 A = [2]
Output 1:
 10
Output 2:
 2
*/
public class LargestRectangleInHistogram {

    public int largestRectangleArea(ArrayList<Integer> A) {
        int n = A.size();
        int[] lMin = new int[n];
        int[] rMin = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                lMin[i] = -1;
            } else {
                lMin[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rMin[i] = n;
            } else {
                rMin[i] = stack.peek();
            }
            stack.push(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int left = lMin[i];
            int right = rMin[i];
            int count = A.get(i) * (right - left - 1);
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        UniqueElements obj = new UniqueElements();
        int[] arr = {2, 2, 2, 2, 2, 2};
        ArrayList<Integer> arrayList = new ArrayList<>();
        obj.addToList(arrayList, arr);

        LargestRectangleInHistogram obj2 = new LargestRectangleInHistogram();
        System.out.println(obj2.largestRectangleArea(arrayList));
    }
}
