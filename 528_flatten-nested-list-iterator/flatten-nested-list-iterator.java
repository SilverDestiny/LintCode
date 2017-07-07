/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/flatten-nested-list-iterator
@Language: Java
@Datetime: 17-01-28 23:29
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
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    
    Stack<Integer> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stack = new Stack<Integer>();
        if (nestedList != null || nestedList.size() != 0) {
            helper(nestedList, stack);
        }
    }
    
    private void helper(List<NestedInteger> nestedList, Stack<Integer> stack) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            NestedInteger obj = nestedList.get(i);
            if (obj.isInteger()) {
                stack.push(obj.getInteger());
            } else {
                helper(obj.getList(), stack);
            }
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return stack.pop();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        return !stack.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */