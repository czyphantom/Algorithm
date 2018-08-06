/**
 * 设计一个支持以下两种操作的数据结构：
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母.或a-z。.可以表示任何一个字母。
 * 难度：Medium
 * 思路：字典树
 */

class WordDictionary {
    private TrieNode root;
    private class TrieNode {
        boolean isWord;
        TrieNode[] next;
 
        public TrieNode() {
            next = new TrieNode[26];
        }
    }
     
    public WordDictionary() {
        root = new TrieNode();
    }
     
    public void addWord(String word) {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        for (char c : chs){
            TrieNode next = cur.next[c-'a'];
            if(next == null){
                cur.next[c-'a'] = new TrieNode();
            }
            cur = cur.next[c-'a'];
        }
        cur.isWord = true;
    }
     
    public boolean search(String word) {
        return search(root,word,0);
    }

    private boolean search(TrieNode root, String express, int index) {
        if (index == express.length()) {
            return root.isWord;
        }
        char c = express.charAt(index);
        if (c != '.') {
            root = root.next[c-'a'];
            if (root == null) {
                return false;
            }
            return search(root, express, index + 1);
        } else {
            TrieNode[] nextNodes = root.next;
            for (int i = 0; i < 26; i++) {
                if (nextNodes[i] != null && search(nextNodes[i], express, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    } 
}