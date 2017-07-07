/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/implement-three-stacks-by-single-array
@Language: Java
@Datetime: 17-01-05 03:33
*/

public class ThreeStacks {

    public int[] p;
    public int[] a;
    public int stackSize;
    public ThreeStacks(int size) {
        // do intialization if necessary
        p = new int[3];
        a = new int[3 * size];
        stackSize = size;
        for (int i = 0; i < 3; i++) {
            p[i] = size * i;
        }
    }

    public void push(int stackNum, int value) {
        // Write your code here
        // Push value into stackNum stack
        a[p[stackNum]] = value;
        p[stackNum]++;
    }
    
    public int pop(int stackNum) {
        // Write your code here
        // Pop and return the top element from stackNum stack
        p[stackNum]--;
        return a[p[stackNum]];
    }

    public int peek(int stackNum) {
        // Write your code here
        // Return the top element
        return a[p[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        // Write your code here
        if (p[stackNum] == stackNum * stackSize) {
            return true;
        } else {
            return false;
        }
    }
}