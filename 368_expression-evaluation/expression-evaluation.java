/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/expression-evaluation
@Language: Java
@Datetime: 17-02-14 03:41
*/

public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
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
     
    public int evaluateExpression(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return 0;
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
            return 0;
        }
        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }
        return dfs(root);
    }
    
    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.symbol);
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.symbol.equals("+")) {
            return left + right;
        } else if (root.symbol.equals("-")) {
            return left - right;
        } else if (root.symbol.equals("*")) {
            return left * right;
        } else {
            return left / right;
        }
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
};