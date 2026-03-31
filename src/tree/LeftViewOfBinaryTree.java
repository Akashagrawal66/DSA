package tree;

import java.util.ArrayList;

/*Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.

Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side

NOTE: The value comes first in the array which have lower level.
Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5
Output 1:
 [1, 2, 4, 8]
Output 2:
 [1, 2, 4, 5]
*/
public class LeftViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        recursive(A, 0, result);
        return result;
    }

    private void recursive(TreeNode a, int height, ArrayList<Integer> result) {
        if (a == null) {
            return;
        }
        if (result.size() <= height) {
            result.add(a.val);
        }
        recursive(a.left, height + 1, result);
        recursive(a.right, height + 1, result);
    }
}
