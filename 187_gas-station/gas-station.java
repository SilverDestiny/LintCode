/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/gas-station
@Language: Java
@Datetime: 17-01-04 15:21
*/

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int total = 0;
        int sum = 0;
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }
        return (total < 0) ? -1 : index + 1;
    }
}