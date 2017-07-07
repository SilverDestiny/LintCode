/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/implement-trie
@Language: Java
@Datetime: 17-02-02 21:17
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
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