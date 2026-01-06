package linkedlists;

import java.util.ArrayList;

/*
Given a binary tree, return the Postorder traversal of its nodes values.
Input 1:
   1
    \
     2
    /
   3
Input 2:
   1
  / \
 6   2
    /
   3
Output 1:
 [3, 2, 1]
Output 2:
 [6, 3, 2, 1]
*/
public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(result, A);
        return result;
    }

    private void postOrder(ArrayList<Integer> result, TreeNode temp) {
        if (temp == null) {
            return;
        }
        if (temp.left != null)
            postOrder(result, temp.left);
        if (temp.right != null)
            postOrder(result, temp.right);
        result.add(temp.val);
    }

    public static void main(String[] args) {
        PostOrderTraversal obj = new PostOrderTraversal();
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(6);
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(3);
        System.out.println(obj.postorderTraversal(head));
    }
}
