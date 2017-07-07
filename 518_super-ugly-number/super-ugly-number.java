/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/super-ugly-number
@Language: Java
@Datetime: 16-11-10 17:49
*/

public class Solution {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        int[] p = new int[primes.length];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < p.length; j++) {
                f[i] = Math.min(f[i], primes[j] * f[p[j]]);
            }
            for (int j = 0; j < p.length; j++) {
                if (primes[j] * f[p[j]] == f[i]) {
                    p[j]++;
                }
            }
        }
        return f[n - 1];
    }
}