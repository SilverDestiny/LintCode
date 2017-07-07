/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 17-03-06 23:58
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, path, result, visited);
        return result;
    }
    
    private void helper(int[] nums, ArrayList<Integer> path, List<List<Integer>> result, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && (i == 0 || nums[i - 1] != nums[i] || (nums[i - 1] == nums[i] && visited[i - 1]))) {
                path.add(nums[i]);
                visited[i] = true;
                helper(nums, path, result, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}


