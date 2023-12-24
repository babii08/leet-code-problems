package medium;/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the medium.MinStack class:

medium.MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:

Input
["medium.MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
medium.MinStack minStack = new medium.MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> minStack;
    Deque<Integer> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        min = Math.min(min, val);
        minStack.push(min);
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? min = Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
