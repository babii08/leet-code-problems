package easy;/*
Easy

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String first = strs[0];
        StringBuilder commonPref = new StringBuilder();
        if (first.isEmpty()) return "";
        int strsLength=strs.length;

        for(int wordI=1; wordI<strsLength; wordI++) {
            if (strs[wordI].isEmpty()) return "";
        }

        for(int charI=0; charI<first.length(); charI++) {
            for(int wordI=1; wordI<strsLength; wordI++) {
                if (
                        charI >= strs[wordI].length() ||
                                first.charAt(charI) != strs[wordI].charAt(charI)
                ) {
                    return commonPref.toString();
                }
            }
            commonPref.append(first.charAt(charI));
        }

        return commonPref.toString();
    }

}
