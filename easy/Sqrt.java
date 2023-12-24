package easy;/*
EASY

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.


Constraints:

0 <= x <= 2^31 - 1
 */

public class Sqrt {

    public int mySqrt(int x) {

        //This squared is the greatest nr less than 2^31 - 1, which is max value for integer;
        int maxNr = 46340;
        if (x < 1) return x;
        if (x >= 2147395600) return maxNr;

        int lower = 1;
        int upper = maxNr;

        int middle = middle(lower, upper);

        while (lower < upper - 1) {
            if (x < lower * lower + 2 * lower) return lower;
            if (x > upper * upper - 2 * upper) return upper - 1;
            if (middle * middle > x) {
                upper = middle;
            } else {
                lower = middle;
            }
            middle = middle(lower, upper);
        }

        return lower;
    }

    public int middle(int a, int b) {
        return (a + b) / 2;
    }

}
