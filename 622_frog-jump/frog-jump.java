/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/frog-jump
@Language: Java
@Datetime: 17-01-31 04:31
*/

public class Solution {
    /**
     * @param stones a list of stones' positions in sorted ascending order
     * @return true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // Write your code here
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        map.put(stones[0], new ArrayList<Integer>());
        map.get(stones[0]).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new ArrayList<Integer>());
        }
        
        for (int i = 0; i < stones.length; i++) {
            for (Integer k : map.get(stones[i])) {
                if (k - 1 > 0 && map.containsKey(stones[i] + k - 1) && !map.get(stones[i] + k - 1).contains(k - 1)) {
                    map.get(stones[i] + k - 1).add(k - 1);
                }
                if (map.containsKey(stones[i] + k) && !map.get(stones[i] + k).contains(k)) {
                    map.get(stones[i] + k).add(k);
                }
                if (map.containsKey(stones[i] + k + 1) && !map.get(stones[i] + k + 1).contains(k + 1)) {
                    map.get(stones[i] + k + 1).add(k + 1);
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() != 0;
    }
}