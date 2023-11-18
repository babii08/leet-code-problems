/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced
 binary search tree.

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
 */

public class SortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) return new TreeNode(nums[0]);

        return createNode(0, nums.length-1, nums);
    }

    TreeNode createNode(int left, int right, int[] nums) {
        if (left > right) return null;

        int mid = middle(left, right);
        return new TreeNode(nums[mid], createNode(left, mid-1, nums), createNode(mid+1, right, nums));
    }

    int middle(int a, int b) {
        return (a + b) / 2;
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
