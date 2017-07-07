/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 16-11-29 19:48
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(candidates, target, path, result, 0);
        return result;
    }
    
    private void helper(int[] candidates, int target, ArrayList<Integer> path, List<List<Integer>> result, int index) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        int prev = -1;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (prev != -1 && prev == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], path, result, i);
            path.remove(path.size() - 1);
            prev = candidates[i];
        }
    }
}