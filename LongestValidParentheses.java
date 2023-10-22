/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring
.

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
 */

import java.util.ArrayList;
import java.util.List;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        // A valid parentheses should have at least 2 elements
        if (s.length() < 2) {
            return 0;
        }

        int stringLength = s.length();
        int firstOpenIndex = 0;

        //Looking for first open parentheses
        while(firstOpenIndex < stringLength && s.charAt(firstOpenIndex) == ')') {
            firstOpenIndex++;
        }

        //If none, return 0
        if(firstOpenIndex == stringLength) {
            return 0;
        }

        //A new list that stores -1, 0 or 1 based on the following logic:
        // 0 - represents a sequence that wasn't closed
        // 1 - represents a sequence that was closed
        // -1 - represents an ')' character that doesn't close any sequence
        // Ex: (()())))(() = 111111-1-1011
        List<Integer> validPosition = new ArrayList<>();
        validPosition.add(0);

        for (int index = firstOpenIndex+1; index<stringLength; index++) {
            char currentParentheses = s.charAt(index);
            if(currentParentheses == '(') {
                // new sequence was opened - adding 0
                validPosition.add(0);
            } else {
                // an existing sequence might be closed, adding 1
                validPosition.add(1);
                int size = validPosition.size();
                int startingIndex = size - 2;
                //going back until encountering 0, or -1, to find the sequence start
                while(validPosition.get(startingIndex) == 1 && startingIndex > 0) {
                    startingIndex--;
                }
                //if the sequence start is not a 0, we have a ')' character that doesn't close any sequence, therefore -1
                if (validPosition.get(startingIndex) != 0) {
                    validPosition.set(size-1, -1);
                } else {
                    //else we close the sequence by changing the previous 0 value to 1
                    validPosition.set(startingIndex, 1);
                }
            }
        }

        int globalMax = 0;
        int local = 0;
        // looking for the longest valid sequence (the longest sequence containing ones)
        for (Integer integer : validPosition) {
            if (integer != 1) {
                globalMax = Math.max(globalMax, local);
                local = 0;
            } else {
                local++;
            }
        }
        return Math.max(globalMax, local);
    }

}
