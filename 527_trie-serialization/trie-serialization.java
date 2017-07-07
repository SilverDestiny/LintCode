/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/trie-serialization
@Language: Java
@Datetime: 17-03-23 22:09
*/

/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TrieNode root) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        StringBuilder path = new StringBuilder();
        dfs(root, path, sb);
        sb.deleteCharAt(0);
        return sb.toString();
    }
    
    private void dfs(TrieNode node, StringBuilder path, StringBuilder sb) {
        if (node.children.size() == 0) {
            sb.append("#");
            sb.append(path);
            return;
        }
        for (char c : node.children.keySet()) {
            path.append(c);
            dfs(node.children.get(c), path, sb);
            path.deleteCharAt(path.length() - 1);
        }
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TrieNode deserialize(String data) {
        // Write your code here
        String[] words = data.split("#");
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }
        return root;
    }
    
    private void insert(TrieNode node, String word) {
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
    }
}
