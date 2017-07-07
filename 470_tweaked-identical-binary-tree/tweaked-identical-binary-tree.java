/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/tweaked-identical-binary-tree
@Language: Java
@Datetime: 16-09-21 16:55
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if (a == null && b == null) {
            return true;
        }
        
        if ((a == null && b != null) || (a != null && b == null) || (a.val != b.val)) {
            return false;
        }
        
        return (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)) || (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left));
    }
}