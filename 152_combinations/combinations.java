/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Java
@Datetime: 17-01-05 01:42
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		helper(result, path, n, k);
		return result;
    }
    
    private void helper(List<List<Integer>> result, ArrayList<Integer> path, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = path.size() == 0 ? 1 : path.get(path.size() - 1) + 1; i <= n; i++) {
            path.add(i);
            helper(result, path, n, k - 1);
            path.remove(path.size() - 1);
        }
    }
}