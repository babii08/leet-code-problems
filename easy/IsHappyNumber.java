/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1
 */
package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsHappyNumber {

    public boolean isHappy(int n) {

        Deque<Integer> powerQueue = new ArrayDeque<>();

        addPowerToQueue(powerQueue, n);

        int queueSize;
        int sum;
        do {
            queueSize = powerQueue.size();
            sum = 0;
            for (int i = 0; i<queueSize; i++) {
                int digit = powerQueue.poll();
                sum += digit * digit;
            }
            addPowerToQueue(powerQueue, sum);
        } while(powerQueue.size() != 1);

        return isHappyResp(powerQueue.poll());
    }

    public static void addPowerToQueue(Deque<Integer> powerQueue, int digit) {
        while(digit != 0) {
            powerQueue.add(digit % 10);
            digit /= 10;
        }
    }

    public static Boolean isHappyResp(int digit) {
        return digit == 1 || digit == 7;
    }

}
