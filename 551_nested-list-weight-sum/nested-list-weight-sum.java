/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/nested-list-weight-sum
@Language: Java
@Datetime: 17-01-28 22:47
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    /*
    //dfs
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger list : nestedList) {
            if (list.isInteger()) {
                sum += list.getInteger() * depth;
            } else {
                sum += helper(list.getList(), depth + 1);
            }
        }
        return sum;
    }
    */
    
    //bfs
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for (NestedInteger list : nestedList) {
            queue.offer(list);
        }
        int sum = 0, depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger temp = queue.poll();
                if (temp.isInteger()) {
                    sum += temp.getInteger() * depth;
                } else {
                    for (NestedInteger inner : temp.getList()) {
                        queue.offer(inner);
                    }
                }
            }
            depth++;
        }
        return sum;
    }
}