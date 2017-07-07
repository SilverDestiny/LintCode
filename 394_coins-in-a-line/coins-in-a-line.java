/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/coins-in-a-line
@Language: Java
@Datetime: 17-02-10 17:43
*/

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        return n % 3 == 0 ? false : true;
    }
}