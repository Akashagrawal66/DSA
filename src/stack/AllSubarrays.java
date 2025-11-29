package stack;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Stack;

/*
Given an integer array A of size N. You have to generate it's all subarrays having a size greater than 1.
Then for each subarray, find Bitwise XOR of its maximum and second maximum element.
Find and return the maximum value of XOR among all subarrays.
Input 1:
 A = [2, 3, 1, 4]
Input 2:
 A = [1, 3]
Output 1:
 7
Outnput 2:
 2
*/
public class AllSubarrays {
    public int solve(ArrayList<Integer> A) {
        int maxXor = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int num : A) {
            while (!stack.isEmpty()) {
                int peekElement = stack.peek();
                maxXor = Math.max(maxXor, peekElement ^ num);
                if (peekElement > num) {
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(num);
        }
        return maxXor;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {9, 8, 3, 5, 7};
        UniqueElements obj = new UniqueElements();
        obj.addToList(list, arr);
        AllSubarrays obj2 = new AllSubarrays();
        System.out.println(obj2.solve(list));
    }
}
