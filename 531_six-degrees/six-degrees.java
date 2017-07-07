/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/six-degrees
@Language: Java
@Datetime: 16-11-17 15:55
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (s == t) {
            return 0;
        }
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        queue.offer(s);
        int degree = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode temp = queue.poll();
                if (set.contains(temp)) {
                    continue;
                }
                if (temp == t) {
                    return degree;
                }
                set.add(temp);
                for (int j = 0; j < temp.neighbors.size(); j++) {
                    queue.offer(temp.neighbors.get(j));
                }
            }
            degree++;
        }
        return -1;
    }
}