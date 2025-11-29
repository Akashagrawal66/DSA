package stack;

import java.util.ArrayList;
import java.util.Stack;

/*
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an
index smaller than i.
More formally,
G[i] for an element A[i] = an element A[j] such that j is maximum possible AND j < i AND A[j] < A[i]
Elements for which no smaller element exist, consider the next smaller element as -1.
Input 1:
 A = [4, 5, 2, 10, 8]
Input 2:
 A = [3, 2, 1]
Output 1:
 [-1, 4, -1, 2, 2]
Output 2:
 [-1, -1, -1]*/
public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : A) {
            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                list.add(-1);
            } else {
                list.add(stack.peek());
            }
            stack.push(num);
        }
        return list;
    }
}
