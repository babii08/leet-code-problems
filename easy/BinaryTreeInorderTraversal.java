package easy;/*
EASY

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversalList = new ArrayList<>();
        if (root == null) return traversalList;

        TreeNode current = root.left;
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        nodeStack.push(root);

        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            traversalList.add(current.val);
            current = current.right;
        }

        return traversalList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
