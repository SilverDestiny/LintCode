/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/find-the-weak-connected-component-in-the-directed-graph
@Language: Java
@Datetime: 17-02-02 17:51
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        for (DirectedGraphNode node : nodes) {
            father.put(node.label, node.label);
        }
        for (DirectedGraphNode node : nodes) {
            int root1 = find(father, node.label);
            for (DirectedGraphNode neighbor : node.neighbors) {
                int root2 = find(father, neighbor.label);
                if (root1 != root2) {
                    father.put(root2, root1);
                }
            }
        }
        for (Integer key : father.keySet()) {
            father.put(key, find(father, key));
        }
        Collection<Integer> roots = father.values();
        HashSet<Integer> set = new HashSet<Integer>();
        for (Integer root : roots) {
            set.add(root);
        }
        for (Integer root : set) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (DirectedGraphNode node : nodes) {
                if (father.get(node.label) == root) {
                    result.add(node.label);
                }
            }
            Collections.sort(result);
            results.add(result);
        }
        return results;
    }
    
    private int find(HashMap<Integer, Integer> father, int node) {
        if (father.get(node) == node) {
            return node;
        }
        father.put(node, find(father, father.get(node)));
        return father.get(node);
    }
}