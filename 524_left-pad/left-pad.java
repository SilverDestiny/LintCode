/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/left-pad
@Language: Java
@Datetime: 17-03-03 20:10
*/

public class StringUtils {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            sb.append(" ");
        }
        sb.append(originalStr);
        return sb.toString();
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            sb.append(padChar);
        }
        sb.append(originalStr);
        return sb.toString();
    }
}