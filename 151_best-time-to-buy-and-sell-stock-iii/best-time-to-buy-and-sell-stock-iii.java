/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Java
@Datetime: 16-11-01 14:27
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int len = prices.length;
        int k = 2;
        //if (k >= len / 2) return quickSolve(prices);
        
        int[][] f = new int[k + 1][len];
        
        for (int i = 1; i <= k; i++) {
            int min = prices[0];
            for (int j = 1; j < len; j++) {
                f[i][j] = Math.max(f[i][j - 1], prices[j] - min);
                min = Math.min(min, prices[j] - f[i - 1][j - 1]);
            }
        }
        return f[k][len - 1];
    }
    
    /*private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }*/
};