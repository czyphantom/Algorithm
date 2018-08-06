/**
 * 题目：实现一个Trie(前缀树)，包含insert, search,和startsWith这三个操作。
 * 难度：Medium
 * 思路：略
 */

class Trie {
    //根节点
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        if(word == "" || word == null){
            return;
        }
        //转为字符数组
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            if(node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }
    
    public boolean search(String word) {
        if(word == null || word == "") {
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            if(node.nexts[index] == null) {
                return false;
            }
            node = node.nexts[index];
        }
        //如果存在以这个节点结尾的word那么说明是存在的
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
        //如果存在以这个节点结尾的word那么说明是存在的
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
        //因为字母有26个，所以初始化为26个
        nexts = new TrieNode[26];
    }
}