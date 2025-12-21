/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 * 题目：Trie（发音类似 "try"）或者说前缀树是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * 难度：Medium
 * 思路：
 */

// @lc code=start
class Trie {

    private Node root;

    public Trie() {
        root = new Node();    
    }
    
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] charArray = word.toCharArray();
        Node node = root;
        for (char c : charArray) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Node();
            }
            node = node.next[index];
            node.path++;
        }
        node.end++;
    }
    
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] charArray = word.toCharArray();
        Node node = root;
        for (char c : charArray) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return node.end > 0;
    }
    
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
              return false;
        }
        char[] charArray = word.toCharArray();
        Node node = root;
        for (char c : charArray) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return true;
    }

    class Node {
        //有多少经过该节点的word
        int path;
        //有多少以当前节点结尾的word
        int end;
        Node[] next;

        public Node() {
            path = 0;
            end = 0;
            next = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

