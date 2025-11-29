package stack;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Stack;

/*
Given a stack of integers A, sort it using another stack.
Return the array of integers after sorting the stack using another stack.
Input 1:
 A = [5, 4, 3, 2, 1]
Input 2:
 A = [5, 17, 100, 11]
Output 1:
 [1, 2, 3, 4, 5]
Output 2:
 [5, 11, 17, 100]
*/
public class SortStackUsingAnotherStack {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int num : A) {
            if (stack1.isEmpty()) {
                stack1.push(num);
                continue;
            }
            while (!stack1.isEmpty() && stack1.peek() < num) {
                stack2.push(stack1.pop());
            }
            stack1.push(num);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        A.replaceAll(ignored -> stack1.pop());
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        int[] arr = {1, 2, 3, 6, 5, 4};
        UniqueElements obj = new UniqueElements();
        obj.addToList(list1, arr);
        SortStackUsingAnotherStack obj2 = new SortStackUsingAnotherStack();
        System.out.println(obj2.solve(list1));
    }
}
