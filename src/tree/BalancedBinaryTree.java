package tree;

/*
Given a root of binary tree A, determine if it is height-balanced.
A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Input 1:
    1
   / \
  2   3
Input 2:
       1
      /
     2
    /
   3
Output 1:
1
Output 2:
0
*/
public class BalancedBinaryTree {
    static class Info {
        int height;
        boolean isBalanced;

        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public int isBalanced(TreeNode A) {
        Info info = recursive(A);
        return info.isBalanced ? 1 : 0;
    }

    private Info recursive(TreeNode a) {
        if (a == null) {
            return new Info(0, true);
        }
        Info leftInfo = recursive(a.left);
        Info rightInfo = recursive(a.right);
        int currHeight = 1 + Math.max(leftInfo.height, rightInfo.height);
        boolean currIsBalanced = (Math.abs(leftInfo.height - rightInfo.height) <= 1) && leftInfo.isBalanced && rightInfo.isBalanced;
        return new Info(currHeight, currIsBalanced);
    }
}
