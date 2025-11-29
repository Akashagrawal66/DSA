package tree.heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recursive(root, sb);
        return result;
    }

    private void recursive(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            sb.append("->");
            recursive(root.left, sb);
            sb.delete(sb.length()-3, sb.length());
        }
        if (root.right != null) {
            sb.append("->");
            recursive(root.right, sb);
            System.out.println("Sb val: "+sb.toString());
            sb.delete(sb.length()-3, sb.length());
            System.out.println("After Sb val: "+sb.toString());
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(37);
        t.left = new TreeNode(-34);
        t.right = new TreeNode(-48);
        t.left.right = new TreeNode(-100);
        t.right.left = new TreeNode(-100);
        t.right.right = new TreeNode(48);
        

        BinaryTreePaths b = new BinaryTreePaths();
        b.binaryTreePaths(t);
        System.out.println(b.result);
    }
}
