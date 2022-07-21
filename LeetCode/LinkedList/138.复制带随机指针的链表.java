/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 * 题目：给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 难度：Medium
 * 思路：先复制节点放到原链表每个节点的后面，再设置随机指针，最后移除原链表。
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
        //第一步，先复制节点到原节点后面
        Node p = head;
        while (p != null) {
            Node next = p.next;
            Node newNode = new Node(p.val);
            p.next = newNode;
            newNode.next = next;
            p = next;
        }

        //第二步，复制节点的random节点
        Node q = head;
        while (q != null) {
            if (q.random != null) {
                q.next.random = q.random.next;
            }
            q = q.next.next;
        }

        //第三步，断开连接
        Node result = head.next,r = head;
        while (r != null) {
            Node temp = r.next;
            r.next = r.next.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            r = r.next;
        }
        return result;
    }
}
// @lc code=end

