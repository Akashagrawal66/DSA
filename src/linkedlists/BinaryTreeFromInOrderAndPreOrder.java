package linkedlists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.
Input 1:
 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:
 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]
Output 1:
   1
  / \
 2   3
Output 2:
   1
  / \
 6   2
    /
   3
*/
public class BinaryTreeFromInOrderAndPreOrder {
    int preIndex = 0;

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            map.put(B.get(i), i);
        }
        return construct(A, B, map, 0, A.size() - 1);
    }

    private TreeNode construct(ArrayList<Integer> a, ArrayList<Integer> b, Map<Integer, Integer> map, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(a.get(preIndex));
        preIndex++;
        int index = map.get(node.val);
        node.left = construct(a, b, map, start, index - 1);
        node.right = construct(a, b, map, index + 1, end);
        return node;
    }
}
