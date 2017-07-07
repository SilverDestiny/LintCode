/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/digit-counts
@Language: Java
@Datetime: 17-01-14 17:13
*/

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    /*public int digitCounts(int k, int n) {
        // write your code here
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += singleCount(i, k);
        }
        return cnt;
    }
    
    public int singleCount(int i, int k) {
        if (i == 0 && k == 0)
            return 1;
        int cnt = 0;
        while (i > 0) {
            if (i % 10 == k) {
                cnt++;
            }
            i = i / 10;
        }
        return cnt;
    }*/
    
    
    public int digitCounts(int k, int n) {
        if (n == 0 && k == 0) {
            return 1;
        }
        int count = 0;
        for (long m = 1; m <= n; m *= 10) {
            if (k == 0 && m * 10 > n) {
                break;
            }
            count += (n / m + 9 - k) / 10 * m + (n / m % 10 == k ? n % m + 1 : 0);
        }
        return count;
    }
    
};
