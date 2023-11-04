/*
Easy
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    public boolean isValid(String s) {

        if (s.length() == 1) return false;

        // round '()' = 0
        // square '[]' = 1
        // curly '{}' = 2


        Map<Character, Integer> braceType = new HashMap<>();
        braceType.put('(', 1);
        braceType.put(')', -1);
        braceType.put('[', 2);
        braceType.put(']', -2);
        braceType.put('{', 3);
        braceType.put('}', -3);

        if (braceType.get(s.charAt(0)) < 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));

        for(int i = 1; i<s.length(); i++) {
            int currentP = braceType.get(s.charAt(i));
            if (currentP < 0 && (stack.isEmpty() || (-1*currentP != braceType.get(stack.peek())))) {
                return false;
            }
            if (currentP > 0) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
