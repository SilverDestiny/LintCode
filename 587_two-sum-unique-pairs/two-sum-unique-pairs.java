/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/two-sum-unique-pairs
@Language: Java
@Datetime: 17-01-30 02:00
*/

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != 3) {
                map.put(nums[i], 2);
            } else if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            
            if (nums[i] * 2 == target && map.get(nums[i]) == 2) {
                count++;
                map.put(nums[i], 3);
            } else if (nums[i] * 2 != target && map.containsKey(target - nums[i]) && map.get(target - nums[i]) != 3) {
                count++;
                map.put(nums[i], 3);
                map.put(target - nums[i], 3);
            }
        }
        /*
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 == target && map.containsKey(nums[i]) && map.get(nums[i]) == 2) {
                count++;
                map.remove(nums[i]);
            } else if (nums[i] * 2 != target && map.containsKey(target - nums[i])) {
                count++;
                map.remove(nums[i]);
                map.remove(target - nums[i]);
            }
        }
        */
        return count;
    }
}