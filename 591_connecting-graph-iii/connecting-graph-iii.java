/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/connecting-graph-iii
@Language: Java
@Datetime: 17-02-01 22:44
*/

public class ConnectingGraph3 {
    private int[] father;
    private int count;
    private int find(int node) {
        if (father[node] == 0) {
            return node;
        }
        return father[node] = find(father[node]);
    }
    
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        count = n;
    }

    public void connect(int a, int b) {
        // Write your code here
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            father[roota] = rootb;
            count--;
        }
    }
        
    public int query() {
        // Write your code here
        return count;
    }
}