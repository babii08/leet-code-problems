package easy;/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numsMap = new HashMap<>();
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            List<Integer> valueList = new ArrayList<>();
            valueList.add(i);
            numsMap.merge(nums[i], valueList,
                    (existingList, newElemList) -> {
                        existingList.add(newElemList.get(0));
                        return existingList;
                    });
        }

        for(var elem : numsMap.keySet()) {
            System.out.println("elem = " + elem);
            if (numsMap.containsKey(target - elem)) {
                System.out.println("target - elem= " + (target - elem) );
                var firstIndex = numsMap.get(elem).get(0);
                var secondIndexList = numsMap.get(target - elem);
                var secondIndex = secondIndexList.get(0);
                if (elem == target-elem) {
                    System.out.println("list");
                    secondIndexList.forEach(System.out::println);
                    secondIndex = secondIndexList.get(1);
                }
                return new int[] {firstIndex, secondIndex};
            }
        }
        return new int[2];
    }
}
