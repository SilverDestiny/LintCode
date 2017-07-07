/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/flatten-2d-vector
@Language: Java
@Datetime: 17-01-29 21:45
*/

public class Vector2D implements Iterator<Integer> {
    
    /*
    Stack<Integer> stack;
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        stack = new Stack<Integer>();
        for (int i = vec2d.size() - 1; i >= 0; i--) {
            for (int j = vec2d.get(i).size() - 1; j >= 0; j--) {
                stack.push(vec2d.get(i).get(j));
            }
        }
    }

    @Override
    public Integer next() {
        // Write your code here
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        return !stack.isEmpty();
    }
    */
    
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        i = vec2d.iterator();
        j = null;
    }

    @Override
    public Integer next() {
        // Write your code here
        hasNext();
        return j.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */