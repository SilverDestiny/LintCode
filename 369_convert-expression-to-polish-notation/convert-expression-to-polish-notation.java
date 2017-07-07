/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/convert-expression-to-polish-notation
@Language: Java
@Datetime: 17-02-14 03:56
*/

public class Solution {
    /**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    class TreeNode {
        int val;
        String symbol;
        TreeNode left, right;
        public TreeNode(int val, String symbol) {
            this.val = val;
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }
    
    public ArrayList<String> convertToPN(String[] expression) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (expression == null || expression.length == 0) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int base = 0;
        int val = 0;
        
        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("(")) {
                base += 10;
                continue;
            }
            if (expression[i].equals(")")) {
                base -= 10;
                continue;
            }
            val = getVal(expression[i], base);
            TreeNode node = new TreeNode(val, expression[i]);
            while (!stack.isEmpty() && node.val <= stack.peek().val) {
                node.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        if (stack.isEmpty()) {
            return result;
        }
        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }
        
        preOrder(root, result);
        return result;
    }
    
    private void preOrder(TreeNode root, ArrayList<String> result) {
        if (root == null) {
            return;
        }
        result.add(root.symbol);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }
    
    private int getVal(String s, int base) {
        if (s.equals("-") || s.equals("+")) {
            return base + 1;
        }
        if (s.equals("*") || s.equals("/")) {
            return base + 2;
        }
        return Integer.MAX_VALUE;
    }
}