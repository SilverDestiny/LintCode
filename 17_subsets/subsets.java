/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 17-01-26 03:03
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            for (int j = 0, size = result.size(); j < size; j++) {
                ArrayList<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
        return result;
    }
}