/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/space-replacement
@Language: Java
@Datetime: 17-01-09 21:39
*/

public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                count++;
            }
        }
        int newLen = length + 2 * count;
        int index = newLen - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] != ' ') {
                string[index] = string[i];
                index--;
            } else {
                string[index] = '0';
                index--;
                string[index] = '2';
                index--;
                string[index] = '%';
                index--;
            }
        }
        return newLen;
    }
}