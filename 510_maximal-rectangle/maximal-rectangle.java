/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/maximal-rectangle
@Language: Java
@Datetime: 17-02-12 22:35
*/

public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // O(mn), for each row it's a Largest Rectangle in Histogram problem
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            int max = 0;
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    if (matrix[i][j]) {
                        height[j]++;
                    } else {
                        height[j] = 0;
                    }
                }
                int curt = 0;
                if (j == n) {
                    curt = -1;
                } else {
                    curt = height[j];
                }
                while (!stack.isEmpty() && curt < height[stack.peek()]) {
                    int h = height[stack.pop()];
                    int w = 0;
                    if (stack.isEmpty()) {
                        w = j;
                    } else {
                        w = j - stack.peek() - 1;
                    }
                    max = Math.max(max, w * h);
                }
                stack.push(j);
            }
            result = Math.max(result, max);
        }
        return result;
    }
}