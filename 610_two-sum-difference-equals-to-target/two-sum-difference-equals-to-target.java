/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/two-sum-difference-equals-to-target
@Language: Java
@Datetime: 17-01-30 01:46
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            map.put(nums[i] + target, i);
            map.put(nums[i] - target, i);
        }
        return result;
    }
}