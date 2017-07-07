/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/route-between-two-nodes-in-graph
@Language: Java
@Datetime: 17-01-08 01:22
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
     
    //dfs
    /*static HashSet<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (s == t) {
            return true;
        }
        for (DirectedGraphNode neighbor : s.neighbors) {
            if (set.contains(neighbor)) {
                continue;
            }
            set.add(neighbor);
            if (hasRoute(graph, neighbor, t)) {
                return true;
            }
        }
        return false;
    }*/
    
    //bfs
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        HashSet<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        queue.offer(s);
        set.add(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode temp = queue.poll();
            if (temp == t) {
                return true;
            }
            for (DirectedGraphNode neighbor : temp.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return false;
    }
}