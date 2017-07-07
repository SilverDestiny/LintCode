/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/update-bits
@Language: Java
@Datetime: 16-12-29 22:08
*/

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int ones = ~0;
        int left;
        if (j == 31) {
            left = 0;
        } else {
            left = ones << (j + 1);
        }
        int right = ((1 << i) - 1);
        int mask = left | right;

        return (n & mask) | (m << i);
    }
}
