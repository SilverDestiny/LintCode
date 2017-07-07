/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/search-graph-nodes
@Language: Java
@Datetime: 17-01-25 17:36
*/

/**
 * Definition for graph node.
 * class GraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        if (graph == null || values == null || node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        queue.offer(node);
        set.add(node);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode temp = queue.poll();
                if (values.get(temp) == target) {
                    return temp;
                }
                for (UndirectedGraphNode neighbor : temp.neighbors) {
                    if (!set.contains(neighbor)) {
                        queue.offer(neighbor);
                        set.add(neighbor);
                    }
                }
            }
        }
        return null;
    }
}