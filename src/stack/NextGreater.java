package stack;

import java.util.ArrayList;
import java.util.Stack;

/*Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.

More formally:

G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.
Input 1:
 A = [4, 5, 2, 10]
Input 2:
 A = [3, 2, 1]
Output 1:
 [5, 10, 10, -1]
Output 2:
 [-1, -1, -1]
*/
public class NextGreater {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i:A) {
            arrayList.add(-1);
        }
        for (int i=A.size()-1;i>=0;i--) {
            int num = A.get(i);
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            arrayList.set(i, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        return arrayList;
    }
}
