/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/container-with-most-water
@Language: Java
@Datetime: 17-02-08 01:13
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int i = 0, j = heights.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(heights[i], heights[j]) * (j - i));
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}