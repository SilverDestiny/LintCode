/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Java
@Datetime: 16-11-07 20:49
*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int start = 0, end = colors.length - 1, count = 0;
        while (count + 1 < k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }
            
            int left = start, right = end, i = left;
            while (i <= right) {
                if (colors[i] == min) {
                    swap(colors, i, left);
                    left++;
                    i++;
                } else if (colors[i] == max) {
                    swap(colors, i, right);
                    right--;
                } else {
                    i++;
                }
            }
            start = left;
            end = right;
            count += 2;
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}