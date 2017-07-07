/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/reverse-integer
@Language: Java
@Datetime: 16-05-10 03:16
*/

public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        int reversed = 0;
        while (n != 0) {
            int temp = n % 10 + reversed * 10;
            if (temp / 10 != reversed) {
                reversed = 0;
                break;
            }
            reversed = temp;
            n = n / 10;
        }
        
        return reversed;
    }
}