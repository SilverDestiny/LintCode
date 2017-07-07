/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/trapping-rain-water
@Language: Java
@Datetime: 17-02-06 05:40
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length < 3) {
            return 0;
        }
        int i = 0, j = heights.length - 1;
        int left = heights[i], right = heights[j];
        int result = 0;
        while (i <= j) {
            if (left < right) {
                if (heights[i] < left) {
                    result += left - heights[i];
                } else {
                    left = heights[i];
                }
                i++;
            } else {
                if (heights[j] < right) {
                    result += right - heights[j];
                } else {
                    right = heights[j];
                }
                j--;
            }
        }
        return result;
    }
}