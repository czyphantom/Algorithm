/**
 * 字典树也叫前缀树，是一种搜索字符串前缀的数据结构，通过以空间换时间的方式来提升搜索的性能。
 */

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