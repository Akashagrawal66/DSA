package linkedlists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Input 1:
    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3
Output 1:
 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:
 [
   [1]
   [6, 2]
   [3]
 ]*/
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (A != null)
            queue.add(A);
        while (!queue.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                arr.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
            result.add(arr);
        }
        return result;
    }
}
