/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/k-edit-distance
@Language: Java
@Datetime: 17-02-22 22:41
*/

public class Solution {
    /**
     * @param words a set of stirngs
     * @param target a target string
     * @param k an integer
     * @return output all the strings that meet the requirements
     */
    class TrieNode {
        TrieNode[] children;
        boolean hasWord;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            hasWord = false;
        }
    }
    
    public void insert(TrieNode root, String word) {
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
        node.word = word;
    }
    
    public List<String> kDistance(String[] words, String target, int k) {
        // Write your code here
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }
        List<String> result = new ArrayList<String>();
        int n = target.length();
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
        find(root, target, k, n, f, result);
        return result;
    }
    
    //dfs + dp on trie tree to find 
    private void find(TrieNode node, String target, int k, int n, int[] f, List<String> result) {
        if (node.hasWord && f[n] <= k) {
            result.add(node.word);
        }
        int[] next = new int[n + 1];
        
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                next[0] = f[0] + 1;
                //same dp as Edit Distance
                for (int j = 1; j <= n; j++) {
                    if (i == target.charAt(j - 1) - 'a') {
                        next[j] = f[j - 1];
                    } else {
                        next[j] = Math.min(f[j - 1], Math.min(f[j], next[j - 1])) + 1;
                    }
                }
                find(node.children[i], target, k, n, next, result);
            }
        }
    }
}