/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/graph-valid-tree
@Language: Java
@Datetime: 17-02-02 16:13
*/

public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int root1 = find(father, edges[i][0]);
            int root2 = find(father, edges[i][1]);
            if (root1 == root2) {
                return false;
            }
            father[root1] = root2;
        }
        return edges.length == n - 1;
    }
    
    private int find(int[] father, int node) {
        if (father[node] == node) {
            return node;
        }
        father[node] = find(father, father[node]);
        return father[node];
    }
}