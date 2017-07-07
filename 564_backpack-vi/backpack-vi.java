/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/backpack-vi
@Language: Java
@Datetime: 16-10-12 19:02
*/

public class Solution {
 /**
 * @param nums an integer array and all positive numbers, no duplicates
 * @param target an integer
 * @return an integer
 */
 public int backPackVI(int[] nums, int target) {
 // Write your code here
    int[] f = new int[target + 1];
    f[0] = 1;
    for (int i = 1; i < target + 1; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                f[i] += f[i - nums[j]];
            }
        }
    }
    return f[target];
 }
}