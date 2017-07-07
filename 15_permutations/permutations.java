/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 17-03-06 18:18
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(nums, path, result);
        return result;
    }
    
    private void helper(int[] nums, ArrayList<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        /*
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                helper(nums, path, result);
                path.remove(path.size() - 1);
            }
        }
        */
        for (int num : nums) {
            if (!path.contains(num)) {
                path.add(num);
                helper(nums, path, result);
                path.remove((Integer) num); // need to convert to Integer object
            }
        }
    }
}
