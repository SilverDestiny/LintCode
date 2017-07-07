/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-tree-serialization
@Language: Java
@Datetime: 16-10-07 15:38
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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }
        ArrayList<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        for (int i = 0; i < q.size(); i++) {
            TreeNode node = q.get(i);
            if (node == null) {
                continue;
            }
            q.add(node.left);
            q.add(node.right);
        }
        while (q.get(q.size() - 1) == null) {
            q.remove(q.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(q.get(0).val);
        for (int i = 1; i < q.size(); i++) {
            if (q.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(q.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> q = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    q.get(index).left = node;
                } else {
                    q.get(index).right = node;
                }
                q.add(node);
            }
            isLeftChild = !isLeftChild;
            if (isLeftChild) {
                index++;
            }
        }
        return root;
    }
}
