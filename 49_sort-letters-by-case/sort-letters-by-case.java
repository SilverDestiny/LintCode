/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/sort-letters-by-case
@Language: Java
@Datetime: 16-11-08 21:35
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length < 2) {
            return;
        }
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] >= 'A' && chars[left] <= 'Z') {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                right--;
            } else {
                left++;
            }
        }
    }
}
