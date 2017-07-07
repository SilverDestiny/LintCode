/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/add-and-search-word
@Language: Java
@Datetime: 17-02-02 22:06
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

public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode node) {
        if (word.length() == 0) {
            return node.hasWord;
        }
        if (word.charAt(0) != '.') {
            int pos = word.charAt(0) - 'a';
            if (node.children[pos] == null) {
                return false;
            }
            if (word.length() > 1) {
                return search(word.substring(1), node.children[pos]);
            } else {
                return search("", node.children[pos]);
            }
        } else {
            boolean flag = false;
            for (int i = 0; i < 26 && !flag; i++) {
                if (node.children[i] != null) {
                    if (word.length() > 1) {
                        flag = search(word.substring(1), node.children[i]);
                    } else {
                        flag = search("", node.children[i]);
                    }
                }
            }
            return flag;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");