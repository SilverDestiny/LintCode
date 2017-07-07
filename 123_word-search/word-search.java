/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/word-search
@Language: Java
@Datetime: 17-02-03 04:18
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == word.charAt(index)) {
            board[i][j] = '#';
            boolean res = helper(board, word, i - 1, j, index + 1) || helper(board, word, i + 1, j, index + 1) || helper(board, word, i, j - 1, index + 1) || helper(board, word, i, j + 1, index + 1);
            board[i][j] = word.charAt(index);
            return res;
        } else {
            return false;
        }
    }
}