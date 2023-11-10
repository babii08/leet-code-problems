/*
EASY

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int i = middle(0, nums.length);

        while (nums[i] != target && left != right-1) {
            if (target < nums[i] ) {
                right = i;
            } else {
                left = i;
            }
            i = middle(left, right);
        }

        if (target == nums[i]) {
            return i;
        }
        if (target > nums[i]) {
            return right;
        }
        return left;
    }

    public int middle(int a, int b) {
        return (a + b) / 2;
    }

}
