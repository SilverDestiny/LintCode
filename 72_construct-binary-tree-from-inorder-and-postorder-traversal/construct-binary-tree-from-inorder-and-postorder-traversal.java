/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-inorder-and-postorder-traversal
@Language: Java
@Datetime: 16-10-03 17:43
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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (postorder.length != inorder.length) {
            return null;
        }
        return helper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend) {
        if (poststart > postend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int pos = 0;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == root.val) {
                pos = i;
                break;
            }
        }
        root.left = helper(postorder, poststart, poststart + pos - instart - 1, inorder, instart, pos - 1);
        root.right = helper(postorder, poststart + pos - instart, postend - 1, inorder, pos + 1, inend);
        return root;
    }
}