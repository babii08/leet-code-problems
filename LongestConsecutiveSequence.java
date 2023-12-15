/*
MEDIUM

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> values = new HashSet<>();

        int maxSequence = 0;

        for (int num : nums) {
            values.add(num);
        }

        int index = 0;
        int curSequence = 0;
        while (index < nums.length && values.size() > 0) {
            int pred = nums[index] - 1;
            int succ = nums[index] + 1;
            while(values.contains(pred)) {
                values.remove(pred);
                curSequence++;
                pred = pred - 1;
            }
            while(values.contains(succ)) {
                values.remove(succ);
                curSequence++;
                succ = succ + 1;
            }
            curSequence++;
            values.remove(nums[index]);
            maxSequence = Math.max(maxSequence, curSequence);
            curSequence = 0;
            index++;
        }

        return maxSequence;

    }

}
