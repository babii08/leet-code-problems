/*
Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        Set<Character> distinct = new HashSet<>();
        distinct.add(s.charAt(0));
        int maxSize = 1;
        int startIndex = 0, endIndex=1;

        for (int i = 1; i<s.length(); i++) {
            if (!distinct.add(s.charAt(i))) {
                maxSize = Math.max(maxSize, endIndex - startIndex);
                while (s.charAt(startIndex) != s.charAt(i)) {
                    distinct.remove(s.charAt(startIndex));
                    startIndex++;
                }
                startIndex++;
            }
            endIndex++;
        }

        maxSize = Math.max(maxSize, endIndex-startIndex);

        return maxSize;
    }

}
