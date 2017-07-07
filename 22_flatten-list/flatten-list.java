/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/flatten-list
@Language: Java
@Datetime: 17-04-02 21:03
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

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    /*recursive
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        helper(nestedList, result);
        return result;
    }
    
    private void helper(List<NestedInteger> list, List<Integer> result) {
        for (NestedInteger curt : list) {
            if (curt.isInteger()) {
                result.add(curt.getInteger());
            } else {
                helper(curt.getList(), result);
            }
        }
    }
    */
    
    //non-recursive
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        pushToStack(stack, nestedList);
        while (!stack.isEmpty()) {
            NestedInteger curt = stack.pop();
            if (curt.isInteger()) {
                result.add(curt.getInteger());
            } else {
                pushToStack(stack, curt.getList());
            }
        }
        return result;
    }
    
    private void pushToStack(Stack<NestedInteger> stack, List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}