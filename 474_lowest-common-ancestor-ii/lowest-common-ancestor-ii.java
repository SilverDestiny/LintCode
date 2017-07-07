/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-ii
@Language: Java
@Datetime: 16-09-21 16:40
*/

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here   
        ArrayList<ParentTreeNode> pathA = findPath(root, A);
        ArrayList<ParentTreeNode> pathB = findPath(root, B);
        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        ParentTreeNode lca = root;
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lca = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return lca;
    }
    
    private ArrayList<ParentTreeNode> findPath(ParentTreeNode root, ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
        while (node != root) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}
