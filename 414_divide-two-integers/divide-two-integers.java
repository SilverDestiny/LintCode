/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/divide-two-integers
@Language: Java
@Datetime: 17-01-26 17:09
*/

public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if (divisor == 0) {
             return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int result = 0;
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        while (a >= b) {
            long temp = b, shift = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                shift <<= 1;
            }
            a -= temp;
            result += shift;
        }
        
        if (negative) {
            return -result;
        } else {
            return result;
        }
    }
}