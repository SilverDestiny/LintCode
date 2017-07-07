/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/drop-eggs
@Language: Java
@Datetime: 17-02-26 23:48
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
     
    public int dropEggs(int n) {
        double res = (Math.sqrt(8.0 * n + 1) - 1) / 2;
        return (int) Math.ceil(res);
    } 
    
    /*
    public int dropEggs(int n) {
        // Write your code here
        long floor = 0;
        for (int i = 1;; i++) {
            floor += i;
            if (floor >= n) {
                return i;
            }
        }
    }
    */
    
   /* public int dropEggs(int n) {
        // Write your code here
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                f[i] = Math.min(f[i], Math.max(j - 1, f[i - j]) + 1);
            }
        }
        return f[n];
    }*/
}