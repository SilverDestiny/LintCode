/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/fibonacci
@Language: Java
@Datetime: 16-05-27 15:42
*/

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        
        int fibo1 = 0, fibo2 = 1, temp;
        for (int i = 3; i <= n; i++) {
            temp = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = temp;
        }
        return fibo2;
    }
}

