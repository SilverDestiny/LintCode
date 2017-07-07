/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/majority-number
@Language: Java
@Datetime: 17-01-03 22:56
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int major = 0, count = 0;
        for (int num : nums) {
            if (num == major) {
                count++;
            } else if (count == 0) {
                major = num;
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}