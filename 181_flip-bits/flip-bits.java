/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/flip-bits
@Language: Java
@Datetime: 17-02-26 21:35
*/

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int count = 0;
        // c & (c - 1) can convert last 1 to 0
        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }
        return count;
    }
};
