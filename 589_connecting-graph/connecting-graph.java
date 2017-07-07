/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/connecting-graph
@Language: Java
@Datetime: 17-02-01 21:02
*/

public class ConnectingGraph { 
    private int[] father;
    private int find(int node) {
        if (father[node] == 0) {
            return node;
        }
        return find(father[node]);
    }
    
    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
    }

    public void connect(int a, int b) {
        // Write your code here
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            father[roota] = rootb;
        }
    }
        
    public boolean query(int a, int b) {
        // Write your code here
        return find(a) == find(b);
    }
}