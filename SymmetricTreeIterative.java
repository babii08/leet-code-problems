/*
EASY

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:

Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:

Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class SymmetricTreeIterative {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null || root.right == null) return root.left == root.right;

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        TreeNode left = root.left;
        TreeNode right = root.right;
        stack1.push(left);
        stack2.push(right);

        while(left != null || !stack1.isEmpty()) {
            while(left != null) {
                if (right == null) return false;
                stack1.push(left);
                left = left.left;
                stack2.push(right);
                right = right.right;
            }

            if (right != null) return false;
            TreeNode nodeLeft = stack1.pop();
            TreeNode nodeRight = stack2.pop();
            if (nodeLeft.val != nodeRight.val) return false;
            left = nodeLeft.right;
            right = nodeRight.left;
        }
        return true;
    }

    private static class TreeNode {
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
