/**
 * 题目：您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。
 * 这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构。扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。 
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }
            Node temp = p.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = p.next;
            if (p.next != null) {
                p.next.prev = temp;
            }
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}