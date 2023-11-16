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


Follow up: Could you solve it both recursively and iteratively?
 */

public class SymmetricTreeRecursive {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null || root.right == null) return root.left == root.right;

        boolean[] isSym = new boolean[1];
        isSym[0] = true;
        inorder(root.left, root.right, isSym);
        return isSym[0];

    }

    public void inorder(TreeNode left, TreeNode right, boolean[] isSym) {
        if (!isSym[0]) return;
        if (left == null || right == null) {
            if (left == right) return;
            isSym[0] = false;
            return;
        }

        inorder(left.left, right.right, isSym);
        if (left.val != right.val) {
            isSym[0] = false;
            return;
        }
        inorder(left.right, right.left, isSym);
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
