/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 17-02-06 22:58
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    /*
    //dfs without stack
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }
    
    private UndirectedGraphNode helper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(helper(neighbor, map));
        }
        return cloneNode;
    }*/
    
    //bfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.poll();
            UndirectedGraphNode cloneNode = null;
            if (map.containsKey(temp.label)) {
                cloneNode = map.get(temp.label);
            } else {
                cloneNode = new UndirectedGraphNode(temp.label);
                map.put(cloneNode.label, cloneNode);
            }
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                UndirectedGraphNode cneighbor = null;
                if (map.containsKey(neighbor.label)) {
                    cneighbor = map.get(neighbor.label);
                } else {
                    queue.offer(neighbor);
                    cneighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(cneighbor.label, cneighbor);
                }
                cloneNode.neighbors.add(cneighbor);
            }
        }
        return map.get(node.label);
    }
}