/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal
@Language: Java
@Datetime: 16-10-03 16:33
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int pos = 0;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == root.val) {
                pos = i;
                break;
            }
        }
        root.left = helper(preorder, prestart + 1, prestart + pos - instart, inorder, instart, pos - 1);
        root.right = helper(preorder, prestart + pos - instart + 1, preend, inorder, pos + 1, inend);
        return root;
    }
}