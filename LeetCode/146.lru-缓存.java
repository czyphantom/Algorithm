/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 * 题目：请你设计并实现一个满足LRU (最近最少使用) 缓存约束的数据结构。
 * 难度：Medium
 * 思路：LinkedHashMap
 */

// @lc code=start
class LRUCache {

    //直接用linkedhashmap
    private LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

    private int capacity = 0;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return linkedHashMap.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        linkedHashMap.put(key, value);
    }

    //标准写法,map+双向链表
    Map<Integer, Node> map;
    int capicity, count;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capicity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    
    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capicity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

}

class Node {
    int key;
    int value;
    Node pre;
    Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

