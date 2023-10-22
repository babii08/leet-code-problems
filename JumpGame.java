/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums[0] == 0) {
            return nums.length == 1;
        }

        int max = nums.length-1;

        for (int index=0; index<=max; index++) {
            if (nums[index] == 0) {
                int conditionalNegative = 0;
                for (int prevToZeroIndex=index-1; prevToZeroIndex>-1; prevToZeroIndex--) {
                    if (nums[prevToZeroIndex] > index-prevToZeroIndex ||
                            index == max && index-prevToZeroIndex == nums[prevToZeroIndex] ) {
                        break;
                    }
                    conditionalNegative++;
                }
                if (conditionalNegative == index) {
                    return false;
                }
            }
        }

        return true;
    }
}
