/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/singleton
@Language: Java
@Datetime: 17-01-08 06:18
*/

class Solution {
    /**
     * @return: The same instance of this class every time
     */
    public static Solution instance = null;
    public static Solution getInstance() {
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }
};