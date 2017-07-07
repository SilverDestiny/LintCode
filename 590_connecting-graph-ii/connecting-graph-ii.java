/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/connecting-graph-ii
@Language: Java
@Datetime: 17-02-01 21:26
*/

public class ConnectingGraph2 {
    private int[] father;
    private int[] size;
    private int find(int node) {
        if (father[node] == 0) {
            return node;
        }
        return father[node] = find(father[node]);
    }

    public ConnectingGraph2(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            father[roota] = rootb;
            size[rootb] += size[roota];
        }
    }
        
    public int query(int a) {
        // Write your code here
        return size[find(a)];
    }
}