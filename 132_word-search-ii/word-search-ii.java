/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/word-search-ii
@Language: Java
@Datetime: 17-02-03 17:30
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    class TrieNode {
    // Initialize your data structure here.
        TrieNode[] children;
        boolean hasWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            hasWord = false;
        }
    }
    
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        int pos = 0;
        for (char c : word.toCharArray()) {
            pos = c - 'a';
            if (node.children[pos] == null) {
                node.children[pos] = new TrieNode();
            }
            node = node.children[pos];
        }
        node.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        int pos = 0;
        for (char c : word.toCharArray()) {
            pos = c - 'a';
            if (node.children[pos] == null) {
                return false;
            }
            node = node.children[pos];
        }
        return node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int pos = 0;
        for (char c : prefix.toCharArray()) {
            pos = c - 'a';
            if (node.children[pos] == null) {
                return false;
            }
            node = node.children[pos];
        }
        return true;
    }
}

    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.size() == 0) {
            return result;
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, "", trie.root, result);
                }
            }
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, String path, TrieNode node, ArrayList<String> result) {
        if (node.hasWord) {
            result.add(path);
            node.hasWord = false;
        }
        
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] != '#' && node.children[board[i][j] - 'a'] != null) {
            char temp = board[i][j];
            board[i][j] = '#';
            dfs(board, i - 1, j, path + temp, node.children[temp - 'a'], result);
            dfs(board, i, j - 1, path + temp, node.children[temp - 'a'], result);
            dfs(board, i + 1, j, path + temp, node.children[temp - 'a'], result);
            dfs(board, i, j + 1, path + temp, node.children[temp - 'a'], result);
            board[i][j] = temp;
        }
    }
}