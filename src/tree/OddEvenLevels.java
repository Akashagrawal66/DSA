package tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
NOTE: Consider the level of root node as 1.
Input 1:
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
  /
 8
Input 2:
        1
       / \
      2   10
       \
        4
Output 1:
 10
Output 2:
 -7
*/
public class OddEvenLevels {
    public int solve(TreeNode A) {
        int sumOdd = 0;
        int sumEven = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (flag) {
                    sumEven += node.val;
                } else {
                    sumOdd += node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            flag = !flag;
        }
        return sumOdd - sumEven;
    }
}
