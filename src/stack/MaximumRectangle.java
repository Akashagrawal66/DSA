package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
Find the largest rectangle containing only 1's and return its area.
Note: Rows are numbered from top to bottom and columns are numbered from left to right.
Input 1:
    A = [   [0, 0, 1]
            [0, 1, 1]
            [1, 1, 1]   ]
Output 1:
    4
Input 2:
    A = [   [0, 1, 0, 1]
            [1, 0, 1, 0]    ]
Output 2:
    1
*/
public class MaximumRectangle {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[] prev = new int[m];
        int max = 0;
        for (ArrayList<Integer> integers : A) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (integers.get(j) == 1) {
                    curr[j] = 1 + prev[j];
                }
            }
            prev = curr;
            max = Math.max(max, largestRectangle(curr, m));
        }
        return max;
    }

    private int largestRectangle(int[] curr, int m) {
        int[] lMin = new int[m];
        int[] rMin = new int[m];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && curr[stack.peek()] >= curr[i]) {
                stack.pop();
            }
            lMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = m - 1; i >= 0; i--) {
            while (!stack.isEmpty() && curr[stack.peek()] >= curr[i]) {
                stack.pop();
            }
            rMin[i] = stack.isEmpty() ? m : stack.peek();
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, curr[i] * (rMin[i] - lMin[i] - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(0);
        list.add(list1);
        list.add(list2);
        MaximumRectangle obj = new MaximumRectangle();
        System.out.println(obj.solve(list));
    }
}
