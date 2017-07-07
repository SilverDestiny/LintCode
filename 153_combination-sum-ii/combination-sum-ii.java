/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 16-11-29 20:07
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null) {
            return result;
        }
        Arrays.sort(num);
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(num, target, path, result, 0);
        return result;
    }
    
    private void helper(int[] num, int target, ArrayList<Integer> path, List<List<Integer>> result, int index) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        int prev = -1;
        for (int i = index; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            if (prev != -1 && prev == num[i]) {
                continue;
            }
            path.add(num[i]);
            helper(num, target - num[i], path, result, i + 1);
            path.remove(path.size() - 1);
            prev = num[i];
        }
    }
}