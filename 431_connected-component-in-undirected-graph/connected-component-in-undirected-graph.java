/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/connected-component-in-undirected-graph
@Language: Java
@Datetime: 16-11-17 23:06
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return result;
        }
        
        while (nodes.size() != 0) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
            Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
            queue.offer(nodes.get(0));
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    UndirectedGraphNode temp = queue.poll();
                    if (set.contains(temp)) {
                        continue;
                    }
                    set.add(temp);
                    path.add(temp.label);
                    nodes.remove(temp);
                    for (int j = 0; j < temp.neighbors.size(); j++) {
                        queue.offer(temp.neighbors.get(j));
                    }
                }
            }
            Collections.sort(path);
            result.add(path);
        }
        return result;
    }
}