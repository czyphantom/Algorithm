/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 * 题目：请你设计并实现一个满足LRU (最近最少使用) 缓存约束的数据结构。
 * 难度：Medium
 * 思路：用map和链表解决
 */

// @lc code=start
class LRUCache {

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
    
    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            putAtFirst(node);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            putAtFirst(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capicity) {
                count++;
                putAtFirst(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                putAtFirst(node);
            }
        }
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void putAtFirst(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
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

