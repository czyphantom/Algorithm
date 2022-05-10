/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 * 题目：Trie（发音类似 "try"）或者说前缀树是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * 难度：Medium
 * 思路：
 */

// @lc code=start
public class Trie {
    //根节点
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        if (word == "" || word == null) {
            return;
        }

        char[] chars = word.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            if(node.nexts[index] == null){
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }
    
    public boolean search(String word) {
        if(word == null || word == ""){
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            if(node.nexts[index] == null){
                return false;
            }
            node = node.nexts[index];
        }
        return node.end > 0;
    }
    
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix == ""){
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            if(node.nexts[index] == null){
                return false;
            }
            node = node.nexts[index];
        }
        return true;
    }
}

class TrieNode{
    //有多少经过该节点的word
    int path;
    //有多少以当前节点结尾的word
    int end;
    //下一个节点，
    TrieNode[] nexts;
    
    public TrieNode() {
        path = 0;
        end = 0;
        nexts = new TrieNode[26];
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

