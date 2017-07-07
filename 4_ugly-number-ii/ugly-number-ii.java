/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Java
@Datetime: 16-11-10 17:34
*/

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] f = new int[n + 1];
        f[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        
        for (int i = 2; i <= n; i++) {
            f[i] = Math.min(Math.min(f[p2] * 2, f[p3] * 3), f[p5] * 5);
            if (f[p2] * 2 == f[i]) {
                p2++;
            }
            if (f[p3] * 3 == f[i]) {
                p3++;
            }
            if (f[p5] * 5 == f[i]) {
                p5++;
            }
        }
        return f[n];
    }
};
