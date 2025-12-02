/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 * 题目：给你一个长度为n的链表，每个节点包含一个额外增加的随机指针random，该指针可以指向链表中的任何节点或空节点。构造这个链表的深拷贝。
 * 难度：Medium
 * 思路：先将新链表放到原链表每一个节点后面，再去设置随机指针，最后把链表拆出来
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node temp = new Node(p.val);
            Node pNext = p.next;
            p.next = temp;
            temp.next = pNext;
            p = pNext;
        }
        Node q = head;
        while (q != null) {
            if (q.random != null) {
                q.next.random = q.random.next;
            }
            q = q.next.next;
        }
        Node r = head,result = head.next, s = head.next;
        while (r != null) {
            r.next = s.next;
            s.next = (s.next != null ? s.next.next : null);
            r = r.next;
            s = s.next;
        }
        return result;
    }
}
// @lc code=end

