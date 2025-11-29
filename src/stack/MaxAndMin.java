package stack;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*Given an array of integers A.
The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
Input 1:
 A = [1]
Input 2:
 A = [4, 7, 3, 8]
Output 1:
 0
Output 2:
 26
*/
public class MaxAndMin {
    public int solve(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        int[] lMin = new int[n];
        int[] rMin = new int[n];
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        extracted(A, n, stack, lMin);
        stack.clear();
        extracted1(A, n, stack, lMax);
        stack.clear();
        extracted2(A, n, stack, rMin);
        stack.clear();
        extracted3(A, n, stack, rMax);
        int mod = (int) (1e9 + 7);
        long result = 0;
        for (int i = 0; i < n; i++) {
            long countMin = (((long) (rMin[i] - i) * (i - lMin[i])) % mod);
            long countMax = (((long) (rMax[i] - i) * (i - lMax[i])) % mod);
            int num = A.get(i);
            result = (result + ((countMax - countMin) * num) % mod) % mod;
        }
        while (result < 0) {
            result += mod;
        }
        return (int) result;
    }

    private static void extracted3(ArrayList<Integer> A, int n, Stack<Integer> stack, int[] rMax) {
        for (int i = n - 1; i >= 0; i--) {
            int num = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) < num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rMax[i] = n;
            } else {
                rMax[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    private static void extracted2(ArrayList<Integer> A, int n, Stack<Integer> stack, int[] rMin) {
        for (int i = n - 1; i >= 0; i--) {
            int num = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) > num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rMin[i] = n;
            } else {
                rMin[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    private static void extracted1(ArrayList<Integer> A, int n, Stack<Integer> stack, int[] lMax) {
        for (int i = 0; i < n; i++) {
            int num = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) < num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                lMax[i] = -1;
            } else {
                lMax[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    private static void extracted(ArrayList<Integer> A, int n, Stack<Integer> stack, int[] lMin) {
        for (int i = 0; i < n; i++) {
            int num = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) > num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                lMin[i] = -1;
            } else {
                lMin[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        UniqueElements obj = new UniqueElements();
        int[] arr = {4, 7, 3, 8};
        ArrayList<Integer> list = new ArrayList<>();
        obj.addToList(list, arr);
        MaxAndMin obj2 = new MaxAndMin();
        System.out.println(obj2.solve(list));
    }
}
