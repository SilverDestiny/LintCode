/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/count-1-in-binary
@Language: Java
@Datetime: 17-01-09 23:14
*/

public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
};