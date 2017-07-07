/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/k-sum-ii
@Language: Java
@Datetime: 16-12-06 20:51
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (A.length < k) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        //boolean[] visited = new boolean[A.length];
        //for (int i = 0; i < A.length; i++) {
        //    visited[i] = false;
        //}
        //int sum = 0;
        
        helper(result, path, A, k, target, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int[] A, int k, int target, int index) {
        if (k == 0) {
            if (target == 0) {
                result.add(new ArrayList<Integer>(path));
                return;
            } else {
                return;
            }
        }
        
        for (int i = index; i < A.length; i++) {
            if (A[i] <= target) {
                path.add(A[i]);
                //visited[i] = true;
                helper(result, path, A, k - 1, target - A[i], i + 1);
                path.remove(path.size() - 1);
                //visited[i] = false;
            }
        }
    }
}