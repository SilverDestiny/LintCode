/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/smallest-rectangle-enclosing-black-pixels
@Language: Java
@Datetime: 17-01-28 21:29
*/

public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
     
    /*
    int left = 0, right = 0, up = 0, down = 0;
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if (image.length == 0 || image[0].length == 0) {
            return 0;
        }
        left = x;
        right = x;
        up = y;
        down = y;
        dfs(image, x, y);
        return (right - left + 1) * (down - up + 1);
    }
    
    private void dfs(char[][] image, int x, int y) {
        image[x][y] = '0';
        if (x - 1 >= 0 && image[x - 1][y] == '1') {
            left = Math.min(left, x - 1);
            dfs(image, x - 1, y);
        }
        if (x + 1 < image.length && image[x + 1][y] == '1') {
            right = Math.max(right, x + 1);
            dfs(image, x + 1, y);
        }
        if (y - 1 >= 0 && image[x][y - 1] == '1') {
            up = Math.min(up, y - 1);
            dfs(image, x, y - 1);
        }
        if (y + 1 < image[0].length && image[x][y + 1] == '1') {
            down = Math.max(down, y + 1);
            dfs(image, x, y + 1);
        }
    }
    */
    
    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int up = searchRow1(image, 0, x);
        int down = searchRow2(image, x, image.length - 1);
        int left = searchCol1(image, 0, y);
        int right = searchCol2(image, y, image[0].length - 1);
        return (right - left + 1) * (down - up + 1);
    }
    
    private int searchRow1(char[][] image, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean exist = false;
            for (int i = 0; i < image[0].length; i++) {
                if (image[mid][i] == '1') {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    private int searchRow2(char[][] image, int start, int end) {
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            boolean exist = false;
            for (int i = 0; i < image[0].length; i++) {
                if (image[mid][i] == '1') {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    
    private int searchCol1(char[][] image, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean exist = false;
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    private int searchCol2(char[][] image, int start, int end) {
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            boolean exist = false;
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}