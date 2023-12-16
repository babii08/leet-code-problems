/*
MEDIUM

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).


Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<List<Integer>>();

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        level.add(root.val);
        result.add(level);

        List<TreeNode> nextLevel = new LinkedList<>();
        addChildren(root, nextLevel);

        while(!nextLevel.isEmpty()) {
            level = new LinkedList<>();
            LinkedList<TreeNode> nodeLevel = new LinkedList<TreeNode>();
            for (int i = 0; i<nextLevel.size(); i++) {
                level.add(nextLevel.get(i).val);
                addChildren(nextLevel.get(i), nodeLevel);
            }
            result.add(level);
            nextLevel = nodeLevel;
        }

        return result;
    }

    public void addChildren(TreeNode node, List<TreeNode> list) {
        if (node.left != null) list.add(node.left);
        if (node.right != null) list.add(node.right);
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
