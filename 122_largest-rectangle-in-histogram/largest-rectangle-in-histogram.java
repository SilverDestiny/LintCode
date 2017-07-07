/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Java
@Datetime: 16-11-14 20:39
*/

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i <= height.length; i++) {
            int curt = 0;
            if (i == height.length) {
                curt = -1;
            } else {
                curt = height[i];
            }
            while (!stack.isEmpty() && curt < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = 0;
                if (stack.isEmpty()) {
                    w = i;
                } else {
                    w = i - stack.peek() - 1;
                }
                max = Math.max(max, w * h);
            }
            stack.push(i);
        }
        return max;
    }
}
