/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/happy-number
@Language: Java
@Datetime: 17-02-25 23:01
*/

public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        HashSet<Integer> set = new HashSet<Integer>();
        
        while (!set.contains(n)) {
            set.add(n);
            int temp = n;
            n = 0;
            while (temp != 0) {
                n += (temp % 10) * (temp % 10);
                temp = temp / 10;
            }
        }
        return n == 1;
    }
}