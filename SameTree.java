/*
EASY

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.



Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false


Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return q == p;
        }

        if (p.val != q.val) return false;

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        TreeNode head1 = p;
        TreeNode head2 = q;

        while(head1 != null || !stack1.isEmpty()) {
            while(head1 != null) {
                if (head2 == null) return false;
                stack1.push(head1);
                stack2.push(head2);
                head1 = head1.left;
                head2 = head2.left;
            }

            if (head2 != null) return false;
            head1 = stack1.pop();
            head2 = stack2.pop();
            if (head1.val != head2.val) return false;
            head1 = head1.right;
            head2 = head2.right;
        }

        return head2 == null && stack2.isEmpty();
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
